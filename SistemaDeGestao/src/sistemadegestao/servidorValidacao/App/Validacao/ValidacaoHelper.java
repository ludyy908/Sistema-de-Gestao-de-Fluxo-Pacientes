package sistemadegestao.servidorValidacao.App.Validacao;


/**
* validacao/ValidacaoHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Validacao.idl
* Tuesday, September 26, 2023 11:20:06 AM CAT
*/

abstract public class ValidacaoHelper
{
  private static String  _id = "IDL:validacao/Validacao:1.0";

  public static void insert (org.omg.CORBA.Any a, sistemadegestao.servidorValidacao.App.Validacao.Validacao that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static sistemadegestao.servidorValidacao.App.Validacao.Validacao extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (sistemadegestao.servidorValidacao.App.Validacao.ValidacaoHelper.id (), "Validacao");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static sistemadegestao.servidorValidacao.App.Validacao.Validacao read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_ValidacaoStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, sistemadegestao.servidorValidacao.App.Validacao.Validacao value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static sistemadegestao.servidorValidacao.App.Validacao.Validacao narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof sistemadegestao.servidorValidacao.App.Validacao.Validacao)
      return (sistemadegestao.servidorValidacao.App.Validacao.Validacao)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      sistemadegestao.servidorValidacao.App.Validacao._ValidacaoStub stub = new sistemadegestao.servidorValidacao.App.Validacao._ValidacaoStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static sistemadegestao.servidorValidacao.App.Validacao.Validacao unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof sistemadegestao.servidorValidacao.App.Validacao.Validacao)
      return (sistemadegestao.servidorValidacao.App.Validacao.Validacao)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      sistemadegestao.servidorValidacao.App.Validacao._ValidacaoStub stub = new sistemadegestao.servidorValidacao.App.Validacao._ValidacaoStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}