package sistemadegestao.servidorOperacoes.services;


/**
* services/ListaHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from clinica.idl
* Monday, September 25, 2023 12:21:25 AM CAT
*/

public final class ListaHolder implements org.omg.CORBA.portable.Streamable
{
  public org.omg.CORBA.Any value[] = null;

  public ListaHolder ()
  {
  }

  public ListaHolder (org.omg.CORBA.Any[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = sistemadegestao.servidorOperacoes.services.ListaHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    sistemadegestao.servidorOperacoes.services.ListaHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return sistemadegestao.servidorOperacoes.services.ListaHelper.type ();
  }

}
