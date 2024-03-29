/* Generated By:JavaCC: Do not edit this line. Compiler.java */
package compiler;
import java.util.HashMap;

public class Compiler implements CompilerConstants {
  // Maps programming language variables to DC registers
  private HashMap < String, Character > variables =
        new HashMap < String, Character > ();

  // Maps programming language variables to types.
  private HashMap<String, String > types =
        new HashMap<String, String >();

  // If the type is not "int", throws a TypeException
  public void checkInt (String type)
  {
    if (!(type.equals("int")))
    {
      throw new TypeException("Expected int, received " + type);
    }
  }

  public void checkBool (String type)
  {
    if (!(type.equals("boolean")))
    {
      throw new TypeException("Expected boolean, received " + type);
    }
  }

  public static void main(String args [])
  {
    Compiler compiler = new Compiler(System.in);
    try
    {
      compiler.program();
    }
    catch (TypeException e)
    {
      System.err.println(e.getMessage());
    }
    catch (ParseException e)
    {
      System.err.println("Parse error: " + e.getMessage());
    }
    catch (TokenMgrError e)
    {
      System.err.println(e.getMessage());
    }
    catch (RuntimeException e)
    {
      System.err.println(e.getMessage());
    }
  }

/***************************** Productions that define grammar *******************/
  final public void program() throws ParseException {
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INTTYPE:
      case STRINGTYPE:
      case PRINT:
      case NEWLINE:
      case READ:
      case BOOLEANTYPE:
      case IF:
      case VAR:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      statement();
    }
    jj_consume_token(0);
  }

  final public void statement() throws ParseException {
  Token t;
  Token vtype;
  String etype;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VAR:
      t = jj_consume_token(VAR);
      jj_consume_token(EQUALS);
      etype = equals();
      jj_consume_token(SEMI);
      if (types.get(t.image) == null)
      {
          {if (true) throw new TypeException("Undeclared variable: " + t.image);}
      }
      if (!types.get(t.image).equals(etype))
          {
                  {if (true) throw new TypeException("Type mismatch");}
      }
      char reg = variables.get(t.image);
      System.out.print("s" + reg + " ");
      break;
    case INTTYPE:
    case STRINGTYPE:
    case BOOLEANTYPE:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INTTYPE:
        vtype = jj_consume_token(INTTYPE);
        break;
      case STRINGTYPE:
        vtype = jj_consume_token(STRINGTYPE);
        break;
      case BOOLEANTYPE:
        vtype = jj_consume_token(BOOLEANTYPE);
        break;
      default:
        jj_la1[1] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      t = jj_consume_token(VAR);
      jj_consume_token(EQUALS);
      etype = equals();
      jj_consume_token(SEMI);
      if (types.get(t.image) == null)
      {
        if (variables.size() >= 26)
        {
          {if (true) throw new TypeException("Too many variables; limit is 26");}
        }
        variables.put(t.image, (char) ('A' + variables.size()));
                types.put(t.image, vtype.image);

                if (!vtype.image.equals(etype))
                {
                  {if (true) throw new TypeException("Type mismatch");}
                }

                char reg2 = variables.get(t.image);
        System.out.print("s" + reg2 + " ");
      }
      else
      {
        {if (true) throw new TypeException("Variable already declared: " + t.image);}
      }
      break;
    case PRINT:
      jj_consume_token(PRINT);
      etype = exp();
      jj_consume_token(SEMI);
      if(etype.equals("boolean")) {
        System.out.print("[true] r 0 [sa [false]] sa =a n");
      } else {
        System.out.print("n ");
      }
      break;
    case NEWLINE:
      jj_consume_token(NEWLINE);
      jj_consume_token(SEMI);
          System.out.print("[] p");
      break;
    case READ:
      jj_consume_token(READ);
      t = jj_consume_token(VAR);
      jj_consume_token(SEMI);
          if (types.get(t.image) == null)
      {
          {if (true) throw new TypeException("Undeclared variable: " + t.image);}
      }
      checkInt(types.get(t.image));
      char reg2 = variables.get(t.image);
      System.out.print("? s" + reg2 + " ");
      break;
    case IF:
      jj_consume_token(IF);
      etype = equals();
      jj_consume_token(RBRACE);
      getStatement('a');
      jj_consume_token(LBRACE);
      jj_consume_token(ELSE);
      jj_consume_token(RBRACE);
      getStatement('b');
      jj_consume_token(LBRACE);
          checkBool(etype);
      System.out.print("la r 0 [sc [lb]] sc =c x");
      break;
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void getStatement(char x) throws ParseException {
    System.out.print("[");
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INTTYPE:
      case STRINGTYPE:
      case PRINT:
      case NEWLINE:
      case READ:
      case BOOLEANTYPE:
      case IF:
      case VAR:
        ;
        break;
      default:
        jj_la1[3] = jj_gen;
        break label_2;
      }
      statement();
    }
    System.out.print("] s" + x);
  }

  final public String equals() throws ParseException {
  Token t;
  String type1, type2;
    type1 = compare();
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case EQUALS:
        ;
        break;
      default:
        jj_la1[4] = jj_gen;
        break label_3;
      }
      t = jj_consume_token(EQUALS);
      jj_consume_token(EQUALS);
      type2 = compare();
      System.out.print("sa 0 r la [sa 1] sa =a ");
      if(type1.equals("boolean")) {
        checkBool(type2);
      }
      else {
                checkInt(type1);
                checkInt(type2);
                type1 = "boolean";
          }
    }
    {if (true) return type1;}
    throw new Error("Missing return statement in function");
  }

  final public String compare() throws ParseException {
  Token t;
  String type1, type2;
    type1 = exp();
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case GREATER:
      case FEWER:
        ;
        break;
      default:
        jj_la1[5] = jj_gen;
        break label_4;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case GREATER:
        t = jj_consume_token(GREATER);
        break;
      case FEWER:
        t = jj_consume_token(FEWER);
        break;
      default:
        jj_la1[6] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      type2 = exp();
      System.out.print("r sa 0 r la [sa 1] sa " + t.image + "a ");
          checkInt(type1);
          checkInt(type2);
          type1 = "boolean";
    }
    {if (true) return type1;}
    throw new Error("Missing return statement in function");
  }

  final public String exp() throws ParseException {
  Token t;
  String type1, type2;
    type1 = term();
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
      case MINUS:
        ;
        break;
      default:
        jj_la1[7] = jj_gen;
        break label_5;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
        t = jj_consume_token(PLUS);
        break;
      case MINUS:
        t = jj_consume_token(MINUS);
        break;
      default:
        jj_la1[8] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      type2 = term();
      System.out.print(t.image + " ");
      checkInt(type1);
          checkInt(type2);
    }
    {if (true) return type1;}
    throw new Error("Missing return statement in function");
  }

  final public String term() throws ParseException {
  Token t;
  String type1, type2;
    type1 = factor();
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MULTIPLY:
      case DIVIDE:
        ;
        break;
      default:
        jj_la1[9] = jj_gen;
        break label_6;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MULTIPLY:
        t = jj_consume_token(MULTIPLY);
        break;
      case DIVIDE:
        t = jj_consume_token(DIVIDE);
        break;
      default:
        jj_la1[10] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      type2 = factor();
      System.out.print(t.image + " ");
      checkInt(type1);
      checkInt(type2);
    }
    {if (true) return type1;}
    throw new Error("Missing return statement in function");
  }

  final public String factor() throws ParseException {
  String type;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case MINUS:
      jj_consume_token(MINUS);
      type = element();
    checkInt(type);
    System.out.print("_1 * ");
    {if (true) return "int";}
      break;
    case NOT:
      jj_consume_token(NOT);
      type = element();
    checkBool(type);
    System.out.print("1 - sa la la * ");
    {if (true) return "boolean";}
      break;
    case LPAREN:
    case TRUE:
    case FALSE:
    case CONSTANT:
    case VAR:
    case STRING:
      type = element();
        {if (true) return type;}
      break;
    default:
      jj_la1[11] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public String element() throws ParseException {
  Token t;
  String type;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case CONSTANT:
      t = jj_consume_token(CONSTANT);
    System.out.print(t.image + " ");
    {if (true) return "int";}
      break;
    case STRING:
      t = jj_consume_token(STRING);
    String dcs = t.image.replaceFirst("\u005c"", "[");
    dcs = dcs.replaceFirst("\u005c"", "]");
        System.out.print(dcs + " ");
        {if (true) return "string";}
      break;
    case VAR:
      t = jj_consume_token(VAR);
    if (types.get(t.image) == null)
    {
                {if (true) throw new TypeException("Undefined variable " + t.image);}
    }
    Character reg = variables.get(t.image);
    System.out.print("l" + reg + " ");
    {if (true) return types.get(t.image);}
      break;
    case LPAREN:
      jj_consume_token(LPAREN);
      type = equals();
      jj_consume_token(RPAREN);
        {if (true) return type;}
      break;
    case TRUE:
    case FALSE:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case TRUE:
        t = jj_consume_token(TRUE);
        break;
      case FALSE:
        t = jj_consume_token(FALSE);
        break;
      default:
        jj_la1[12] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    if(t.image == "true") {
      System.out.print("1 ");
    } else if(t.image == "false"){
      System.out.print("0 ");
    }
        {if (true) return "boolean";}
      break;
    default:
      jj_la1[13] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  /** Generated Token Manager. */
  public CompilerTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[14];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x41071c00,0x40c00,0x41071c00,0x41071c00,0x20,0x600000,0x600000,0xc0,0xc0,0x300,0x300,0x50984080,0x180000,0x50184000,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x1,0x0,0x1,};
   }

  /** Constructor with InputStream. */
  public Compiler(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Compiler(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new CompilerTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Compiler(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new CompilerTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Compiler(CompilerTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(CompilerTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[33];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 14; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 33; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}

/**
 * Exception used to report type-checking errors.
 */
 class TypeException extends RuntimeException
 {
   public TypeException (String message)
   {
     super(message);
   }
 }
