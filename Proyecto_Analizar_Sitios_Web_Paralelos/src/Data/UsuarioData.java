/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import Domain.Usuario;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

/**
 *
 * @author Usuario
 */
public class UsuarioData {

    private Document document;
    private Element root;
    private String ruta;

    public UsuarioData(String ruta) throws JDOMException, IOException {
        this.ruta = ruta;
        File archivo = new File(this.ruta);
        if (archivo.exists()) {
            SAXBuilder saxBuilder = new SAXBuilder();
            saxBuilder.setIgnoringElementContentWhitespace(true);
            this.document = saxBuilder.build(this.ruta);
            this.root = this.document.getRootElement();
        } else {
            this.root = new Element("Usuarios");
            this.document = new Document(this.root);
            guardarXML();
        }
    }

    private void guardarXML() throws FileNotFoundException, IOException {

        XMLOutputter xmlOutputter = new XMLOutputter();
        xmlOutputter.output(this.document, new PrintWriter(this.ruta));
    }

    public void registrarJugador(Usuario usuario) throws IOException {

        Element eUsuario = new Element("Jugador");
        eUsuario.setAttribute("nombre", usuario.getNombre());

        Element eApellidos = new Element("Apellidos");
        eApellidos.addContent(usuario.getApellidos());

        Element eId = new Element("Id Usuario");
        eId.addContent(usuario.getIdUsuario());

        Element eRol = new Element("Rol");
        eRol.addContent(usuario.getRol());

        Element ePassword = new Element("Password");
        ePassword.addContent(usuario.getRol());
        
        Element eTareas = new Element("Tareas");
        eTareas.addContent("");
        
        eUsuario.addContent(eApellidos);
        eUsuario.addContent(eId);
        eUsuario.addContent(eRol);
        eUsuario.addContent(eTareas);
        
        this.root.addContent(eUsuario);
        this.guardarXML();
    }

    public boolean buscarJugador(Usuario usuario) {

        List elementList = this.root.getChildren();
        for (Object object : elementList) {
            Element eUsuario = (Element) object;
            if (eUsuario.getAttributeValue("Id Usuario").equals(usuario.getIdUsuario())
                    && eUsuario.getChild("Password").getValue().equals(usuario.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public boolean buscarUsuarioPorNombre(  jugador) {

        List elementList = this.root.getChildren();
        for (Object object : elementList) {
            Element eUsuario = (Element) object;
            if (eUsuario.getAttributeValue("nombre").equals(jugador.getNombre())) {
                return true;
            }
        }
        return false;
    }

    public boolean buscarAmigo(String jug1, String jug2) {
        List elementList = this.root.getChildren();
        for (Object object : elementList) {
            Element eUsuario = (Element) object;
            if (eUsuario.getAttributeValue("nombre").equals(jug1)) {
                List amigosList = eUsuario.getChild("amigos").getChildren();
                for (Object object1 : amigosList) {
                    Element eAmigo = (Element) object1;
                    if (eAmigo.getValue().equals(jug2)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public String listaAmigos(String jug1) {
        String listaAmigos = "";
        List elementList = this.root.getChildren();
        for (Object object : elementList) {
            Element eUsuario = (Element) object;
            if (eUsuario.getAttributeValue("nombre").equals(jug1)) {
                eUsuario.getChildren("amigos");
                List eAmigos = eUsuario.getChildren("amigos");
                for (Object object1 : eAmigos) {
                    Element eAmigo = (Element) object1;
                    listaAmigos += eAmigo.getChild("amigo").getValue() + ",";
                }
            }
        }
        return listaAmigos;
    }

    public Jugador getUsuario(Jugador jugador) {

        List elementList = this.root.getChildren();
        for (Object object : elementList) {
            Element eUsuario = (Element) object;
            if (eUsuario.getAttributeValue("nombre").equals(jugador.getNombre())
                    && eUsuario.getChild("contrasenia").getValue().equals(jugador.getContrasenia())) {
                return new Jugador(
                        eUsuario.getAttributeValue("nombre"),
                        eUsuario.getChild("contrasenia").getValue(),
                        eUsuario.getChild("img").getValue());
            }
        }
        return null;
    }

    public void agregarAmigo(String usuario, String tarea, String Url) throws IOException {
        List tareas = this.root.getChildren();

        for (Object object : tareas) {
            Element eJugador = (Element) object;
                if (eJugador.getAttributeValue("Id Usuario").equals(usuario1)) {

                Element eTarea = new Element("Tarea");
                eAmigo.addContent(jugador2);

                eJugador.getChild("Tareas").addContent(eAmigo);
                this.guardarXML();
            }
        }
    }

}
