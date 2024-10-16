import java.io.*;
import java.util.*;

%%

%class Lexer
%unicode
%line
%column
%type Token

%{
  HashSet<String> symbolTable = new HashSet<>();

  public enum Token {
    OPERATOR, PARENTHESIS, SEMICOLON, KEYWORD, INTEGER, IDENTIFIER, STRING, ERROR
  }
%}

LineTerminator = \r|\n|\r\n
WhiteSpace     = {LineTerminator} | [ \t\f]

// 2.1 Operators
Operator = "+" | "-" | "*" | "/" | "=" | ">" | ">=" | "<" | "<=" | "==" | "++" | "--"

// 2.2 Parentheses and Semicolon
Parenthesis = "(" | ")"
Semicolon   = ";"

// 2.3 Keywords
Keyword = "if" | "then" | "else" | "endif" | "while" | "do" | "endwhile" | "print" | "newline" | "read"

// 2.4 Integers
Integer = 0 | [1-9][0-9]*

// 2.5 Identifiers
Identifier = [a-zA-Z][a-zA-Z0-9]*

// 2.6 Strings
String = \"[^\"]*\"

// 2.7 Comments
Comment = {TraditionalComment} | {EndOfLineComment}
TraditionalComment = "/*" [^*] ~"*/" | "/*" "*"+ "/"
EndOfLineComment = "//" {InputCharacter}* {LineTerminator}?
InputCharacter = [^\r\n]

%%

{Operator}      { return Token.OPERATOR; }
{Parenthesis}   { return Token.PARENTHESIS; }
{Semicolon}     { return Token.SEMICOLON; }
{Keyword}       { return Token.KEYWORD; }
{Integer}       { return Token.INTEGER; }
{Identifier}    { 
  if (symbolTable.add(yytext())) {
    System.out.println("new identifier: " + yytext());
  } else {
    System.out.println("identifier \"" + yytext() + "\" already in symbol table");
  }
  return Token.IDENTIFIER;
}
{String}        { return Token.STRING; }
{Comment}       { /* ignore */ }
{WhiteSpace}    { /* ignore */ }

// 2.8 Other data
[^]             { 
  System.out.println("Error: Unexpected character '" + yytext() + "' at line " + yyline + ", column " + yycolumn);
  return Token.ERROR;
}