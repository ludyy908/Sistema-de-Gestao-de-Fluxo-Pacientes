package sistemadegestao.servidorValidacao.App.Output;

import java.io.IOException;


/**
* OutputOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Output.idl
* Monday, September 25, 2023 11:56:00 AM CAT
*/

public interface OutputOperations 
{
  void mensagem (String mensagem) throws IOException;
  String mensagemString (String mensagem) throws IOException;
  byte mensagemByte (String mensagem) throws IOException;
  int mensagemInt (String mensagem) throws IOException;
  String mensagemChar (String mensagem) throws IOException;
} // interface OutputOperations