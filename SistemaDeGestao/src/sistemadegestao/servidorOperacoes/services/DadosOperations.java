package sistemadegestao.servidorOperacoes.services;


/**
* services/DadosOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from clinica.idl
* Monday, September 25, 2023 12:21:25 AM CAT
*/

public interface DadosOperations 
{
  void agendarCirurgia ();
  void agendarConsulta ();
  void cancelar (String tipo);
  void darAltaPaciente ();
  void internarPaciente ();
  void registarPaciente ();
  void registarEnf ();
  void registarMed ();
  org.omg.CORBA.Any[] getdados ();
  void lerDados ();
  void gravarDados ();
} // interface DadosOperations
