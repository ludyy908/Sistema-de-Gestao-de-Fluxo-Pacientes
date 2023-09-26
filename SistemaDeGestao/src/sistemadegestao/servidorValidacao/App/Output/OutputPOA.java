package sistemadegestao.servidorValidacao.App.Output;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
* OutputPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Output.idl
* Monday, September 25, 2023 11:56:00 AM CAT
*/

public abstract class OutputPOA extends org.omg.PortableServer.Servant
 implements OutputOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("mensagem", new java.lang.Integer (0));
    _methods.put ("mensagemString", new java.lang.Integer (1));
    _methods.put ("mensagemByte", new java.lang.Integer (2));
    _methods.put ("mensagemInt", new java.lang.Integer (3));
    _methods.put ("mensagemChar", new java.lang.Integer (4));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // Output/mensagem
       {
         String mensagem = in.read_string ();
        try {
            this.mensagem (mensagem);
        } catch (IOException ex) {
            Logger.getLogger(OutputPOA.class.getName()).log(Level.SEVERE, null, ex);
        }
         out = $rh.createReply();
         break;
       }

       case 1:  // Output/mensagemString
       {
         String mensagem = in.read_string ();
         String $result = null;
        try {
            $result = this.mensagemString (mensagem);
        } catch (IOException ex) {
            Logger.getLogger(OutputPOA.class.getName()).log(Level.SEVERE, null, ex);
        }
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 2:  // Output/mensagemByte
       {
         String mensagem = in.read_string ();
         byte $result = (byte)0;
        try {
            $result = this.mensagemByte (mensagem);
        } catch (IOException ex) {
            Logger.getLogger(OutputPOA.class.getName()).log(Level.SEVERE, null, ex);
        }
         out = $rh.createReply();
         out.write_octet ($result);
         break;
       }

       case 3:  // Output/mensagemInt
       {
         String mensagem = in.read_string ();
         int $result = (int)0;
        try {
            $result = this.mensagemInt (mensagem);
        } catch (IOException ex) {
            Logger.getLogger(OutputPOA.class.getName()).log(Level.SEVERE, null, ex);
        }
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       case 4:  // Output/mensagemChar
       {
         String mensagem = in.read_string ();
         String $result = null;
        try {
            $result = this.mensagemChar (mensagem);
        } catch (IOException ex) {
            Logger.getLogger(OutputPOA.class.getName()).log(Level.SEVERE, null, ex);
        }
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:Output:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Output _this() 
  {
    return OutputHelper.narrow(
    super._this_object());
  }

  public Output _this(org.omg.CORBA.ORB orb) 
  {
    return OutputHelper.narrow(
    super._this_object(orb));
  }


} // class OutputPOA
