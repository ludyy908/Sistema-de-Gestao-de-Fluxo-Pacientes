package sistemadegestao.servidorOperacoes.services;

/**
* services/DadosHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from clinica.idl
* Tuesday, September 26, 2023 12:11:44 PM CAT
*/

public final class DadosHolder implements org.omg.CORBA.portable.Streamable
{
  public sistemadegestao.servidorOperacoes.services.Dados value = null;

  public DadosHolder ()
  {
  }

  public DadosHolder (sistemadegestao.servidorOperacoes.services.Dados initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = sistemadegestao.servidorOperacoes.services.DadosHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
        sistemadegestao.servidorOperacoes.services.DadosHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return sistemadegestao.servidorOperacoes.services.DadosHelper.type ();
  }

}
