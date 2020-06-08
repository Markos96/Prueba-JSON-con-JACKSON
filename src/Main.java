import java.awt.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;


public class Main {

	public static void main(String[] args)throws IOException {
		
		Usuario usar = new Usuario(1,"Marcos");
		Usuario user = new Usuario(2,"Gaston");
		Usuario usir = new Usuario(3,"Solari");
		Usuario usarr = new Usuario(4,"Chino");
		Usuario andres = new Usuario(8,"Andres");
		
		ArrayList<Usuario>users = new ArrayList<Usuario>();
		
		users.add(user);
		users.add(usar);
		users.add(usir);
		users.add(usarr);
		users.add(andres);
		
		for(int i=0; i<users.size();i++) {
			System.out.println("ID: "+ users.get(i).getId());
			System.out.println("Nombre: "+ users.get(i).getNombre());
		}

		String directorio = "C:\\Users\\pc 01\\Desktop\\TrabajosRealizados\\texto.json";
		
	File jason = new File(directorio);
		
	
	
			try {
				if(!jason.exists())
					{
				jason.createNewFile();
				System.out.print("El archivo se creo con exito");
				System.out.print("\n"+ jason.getName());
					}
				else
					{
					System.out.println("Ya existe un archivo");
					}
				if(!jason.canWrite()){
					jason.setWritable(true);
					}
				
				// ESCRIBO Y SERIALIZO LOS DATOS DE LA COLLECTION A JSON MEDIANTE JACKSON.
				
				 	
				
				ObjectMapper mapper = new ObjectMapper();
				mapper.writeValue(jason, users);
				
				
				// LEO Y DESERIALIZO LOS DATOS DEL JSON Y LOS PASO A OBJECT JAVA MEDIANTE JACKSON.
				if(!jason.canRead()){
					jason.setReadable(true);
					}
				
						ArrayList<Usuario> list = mapper.readValue(new FileInputStream(jason),
	                    mapper.getTypeFactory().constructCollectionType(ArrayList.class, Usuario.class));
						System.out.println(list);
						
				
						/*Usuario usuario = mapper.readValue(jason, Usuario.class);
						System.out.println("Jackson: " + usuario.toString());*/
				
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		
		
	}

}
