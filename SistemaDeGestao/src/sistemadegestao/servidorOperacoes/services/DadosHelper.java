package sistemadegestao.servidorOperacoes.services;


/**
* services/DadosHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from clinica.idl
* Tuesday, September 26, 2023 12:11:44 PM CAT
*/

abstract public class DadosHelper
{
  private static String  _id = "IDL:services/Dados:1.0";

  public static void insert (org.omg.CORBA.Any a, sistemadegestao.servidorOperacoes.services.Dados that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static sistemadegestao.servidorOperacoes.services.Dados extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (sistemadegestao.servidorOperacoes.services.DadosHelper.id (), "Dados");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static sistemadegestao.servidorOperacoes.services.Dados read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_DadosStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, sistemadegestao.servidorOperacoes.services.Dados value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static sistemadegestao.servidorOperacoes.services.Dados narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof sistemadegestao.servidorOperacoes.services.Dados)
      return (sistemadegestao.servidorOperacoes.services.Dados)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
            sistemadegestao.servidorOperacoes.services._DadosStub stub = new sistemadegestao.servidorOperacoes.services._DadosStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static sistemadegestao.servidorOperacoes.services.Dados unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof sistemadegestao.servidorOperacoes.services.Dados)
      return (sistemadegestao.servidorOperacoes.services.Dados)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
            sistemadegestao.servidorOperacoes.services._DadosStub stub = new sistemadegestao.servidorOperacoes.services._DadosStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
