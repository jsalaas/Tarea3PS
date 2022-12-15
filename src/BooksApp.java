package tarea3;

import java.util.*;

public class BooksApp {
	
    static Scanner sn = new Scanner(System.in);
    
    static List<List<String>> load_books(){
    	List<List<String>> libros = new ArrayList<>();
        
    	List<String> libro1 = new ArrayList<>();
        libro1.add ("Sonata a Kreutzer");
        libro1.add ("Leon Tolstoi");
        libro1.add ("2011");
        libro1.add ("168");
        libro1.add ("Acantilado");
        libro1.add ("Novela");
        libro1.add ("8496136280");
        libro1.add ("1;3;B;(5,15)");
        libro1.add ("Disponible");
        libro1.add ("Su titulo es tomado de la composición homónima para violín y piano de Ludwig Van Beethoven.");
        
        List<String> libro2 = new ArrayList<>();
        libro2.add ("Relatos de Sebastopol");
        libro2.add ("Leon Tolstoi");
        libro2.add ("2013");
        libro2.add ("216");
        libro2.add ("Alba Editorial");
        libro2.add ("Relato corto");
        libro2.add ("9788484288978");
        libro2.add ("2;1;D;(1,7)");
        libro2.add ("Disponible");
        libro2.add ("Tres relatos cortos que documentan las experiencias del autor durante el sitio de Sebastopol.");
        
        List<String> libro3 = new ArrayList<>();
        libro3.add ("El idiota");
        libro3.add ("Fiodor Dostoievski");
        libro3.add ("2019");
        libro3.add ("766");
        libro3.add ("Penguin Clásicos");
        libro3.add ("Novela");
        libro3.add ("9788491054030");
        libro3.add ("1;6;A;(5,13)");
        libro3.add ("Prestado");
        libro3.add ("Es considerada de las novelas más brillantes por el autor ruso y de la 'Edad de Oro' en la literatura rusa.");
        
        libros.add(libro1);
        libros.add(libro2);
        libros.add(libro3);
        return libros;
    }
    
    static List<List<String>> add_book(List<List<String>> libros, List<String> nuevoLibro){
        libros.add(nuevoLibro);
        return libros;
    }
    
    static List<List<String>> find_book (List<List<String>> libros, List<String> propFilter){
    	List<List<String>> busqueda = new ArrayList<>();
    	if (propFilter.size() == 1) {
    		for (int i = 0; i < libros.size(); i++) {
    			if (libros.get(i).contains(propFilter.get(0))) {
    				busqueda.add(libros.get(i));
    			}
    		}
    	}
    	else if (propFilter.size() == 2) {
        	List<List<String>> temp = new ArrayList<>();
        	for (int i = 0; i < libros.size(); i++) {
    			if (libros.get(i).contains(propFilter.get(0))) {
    				temp.add(libros.get(i));
    			}
    		}
        	for (int i = 0; i < temp.size(); i++) {
    			if (temp.get(i).contains(propFilter.get(1))) {
    				busqueda.add(temp.get(i));
    			}
    		}
    	}
    	else if (propFilter.size() == 3) {
    		List<List<String>> temp1 = new ArrayList<>();
    		List<List<String>> temp2 = new ArrayList<>();
        	for (int i = 0; i < libros.size(); i++) {
    			if (libros.get(i).contains(propFilter.get(0))) {
    				temp1.add(libros.get(i));
    			}
    		}
        	for (int i = 0; i < temp1.size(); i++) {
    			if (temp1.get(i).contains(propFilter.get(1))) {
    				temp2.add(temp1.get(i));
    			}
    		}
        	for (int i = 0; i < temp2.size(); i++) {
    			if (temp2.get(i).contains(propFilter.get(1))) {
    				busqueda.add(temp2.get(i));
    			}
    		}
    	}
    	return busqueda;
    }
    
    static List<List<String>> edit_book (List<List<String>> libros, int libroEditado, int opcionEdicion, String nuevaInfo){
    	(libros.get(libroEditado)).set((opcionEdicion-1), nuevaInfo);
        return libros;
    }
    
    static List<List<String>> delete_book(List<List<String>> libros, int libroBorrado){
    	libros.remove(libroBorrado);
        return libros;
    }

	public static void main(String[] args) throws Exception {
		
		List<List<String>> libros = new ArrayList<>();
		
		libros = load_books();
				
		boolean salir = false;
		int opcion;
		
		while (!salir) {
			System.out.println("\n\n Sistema de información de biblioteca");
			System.out.println("MENU:");
			System.out.println("1. Ingresar nuevo libro");
			System.out.println("2. Buscar libro");
			System.out.println("3. Editar libro");
			System.out.println("4. Eliminar libro");
			System.out.println("5. Salir del sistema");
			
			try {
				System.out.println("Ingrese una opción: ");
				opcion = sn.nextInt();
				
				switch (opcion) {
				case 1:
					System.out.println("\nNuevo libro\n");
					List<String> nuevoLibro = new ArrayList<>();
					String infoLibro;
					
					//TITULO
					
					//por posible condición de carrera entre los nextLine y el while, se incluyen dos nextLine()
					infoLibro = sn.nextLine();
					System.out.print("Título: ");
					infoLibro = sn.nextLine();
					
					while (infoLibro.isEmpty()){
	                    System.out.println("El libro debe poseer un título");
	                    System.out.print("Título: ");
	                    infoLibro = sn.nextLine();
	                }
					nuevoLibro.add(infoLibro);
					
					//AUTOR(ES)
					
					System.out.print("Autor(es) (en caso de múltiples autores, usa el ',' como delimitador): ");
					infoLibro = sn.nextLine();
					
	                while (infoLibro.isEmpty()){
	                    System.out.println("El libro debe tener uno o más autores.");
	                    System.out.print("Autor(es) (en caso de múltiples autores, usa el ',' como delimitador): ");
	                    infoLibro = sn.nextLine();
	                }
	                nuevoLibro.add(infoLibro);
	                
	                //FECHA EDICIÓN

					System.out.print("Fecha de edición: ");
					infoLibro = sn.nextLine();
					
	                while (infoLibro.isEmpty()){
	                    System.out.println("El libro debe tener una fecha de edición.");
	                    System.out.print("Fecha de edición: ");
	                    infoLibro = sn.nextLine();
	                }
	                nuevoLibro.add(infoLibro);
	                
	                //NÚMERO DE PÁGINAS

					System.out.print("Número de páginas: ");
					infoLibro = sn.nextLine();
					
	                while (infoLibro.isEmpty()){
	                    System.out.println("El libro debe tener un número definido de páginas.");
	                    System.out.print("Número de páginas: ");
	                    infoLibro = sn.nextLine();
	                }
	                nuevoLibro.add(infoLibro);
	                
	                //EDITORIAL

					System.out.print("Editorial: ");
					infoLibro = sn.nextLine();
					
	                while (infoLibro.isEmpty()){
	                    System.out.println("El libro debe tener una editorial asociada.");
	                    System.out.print("Editorial: ");
	                    infoLibro = sn.nextLine();
	                }
	                nuevoLibro.add(infoLibro);
	                
	                //GÉNERO

					System.out.print("Género: ");
					infoLibro = sn.nextLine();
					
	                while (infoLibro.isEmpty()){
	                    System.out.println("El libro debe pertenecer a un género literario.");
	                    System.out.print("Género: ");
	                    infoLibro = sn.nextLine();
	                }
	                nuevoLibro.add(infoLibro);
	                
	                //ISBN

					System.out.print("ISBN: ");
					infoLibro = sn.nextLine();
					
	                while (infoLibro.isEmpty()){
	                    System.out.println("El libro debe poseer un codigo ISBN.");
	                    System.out.print("Género: ");
	                    infoLibro = sn.nextLine();
	                }
	                nuevoLibro.add(infoLibro);
	                
	                //UBICACIÓN

					System.out.print("Ubicación (piso, pasillo, estante, (x;y)): ");
					infoLibro = sn.nextLine();
					String[] datosPosicion = infoLibro.split(",");
					
	                while (infoLibro.isEmpty() || datosPosicion.length != 4){
	                    System.out.println("Faltó algún dato o entregaste datos en formato incorrecto.");
	                    System.out.print("Ubicación (piso, pasillo, estante, (x;y)): ");
	                    infoLibro = sn.nextLine();
	                    datosPosicion = infoLibro.split(",");
	                }
	                nuevoLibro.add(infoLibro);
	                
	                //ESTADO
	                
					System.out.print("Estado (Prestado, disponible, extraviado): ");
					infoLibro = sn.nextLine();
					infoLibro = infoLibro.toLowerCase();
					
	                while (!(infoLibro.equals("prestado") || infoLibro.equals("disponible") || infoLibro.equals("extraviado"))){
	                    System.out.println("Estado inválido.");
	                    System.out.print("Estado (Prestado, disponible, extraviado): ");
	                    infoLibro = sn.nextLine();
	                    infoLibro = infoLibro.toLowerCase();
	                }
	                nuevoLibro.add(infoLibro);
	                
	                //DESCRIPCIÓN

					System.out.print("Descripción: ");
					infoLibro = sn.nextLine();
					
	                while (infoLibro.isEmpty()){
	                    System.out.println("El libro debe poseer una descripción.");
	                    System.out.print("Descripción: ");
	                    infoLibro = sn.nextLine();
	                }
	                nuevoLibro.add(infoLibro);
	                
	                List<List<String>> registro = add_book(libros, nuevoLibro);
	                libros = new ArrayList<>(registro);
	                System.out.println("Libro agregado");
					break;
				case 2:
					System.out.println("\nBúsqueda de libros\n Ingrese alguno de los siguientes datos para la búsqueda:");
					List<String> propFilter = new ArrayList<>();
					
					String titulo, autor, isbn;
					titulo = sn.nextLine();
					System.out.print("Titulo: ");
	                titulo = sn.nextLine();
	                System.out.print("Autor(es) (en caso de múltiples autores, usa el ',' como delimitador): ");
	                autor = sn.nextLine();
	                System.out.print("ISBN: ");	                
	                isbn = sn.nextLine();
	                
	                while (titulo.equals("") && autor.equals("") && isbn.equals((""))) {
	                    System.out.println("\nDebes ingresar al menos algún dato del libro para efectuar la búsqueda. Intenta de nuevo.\n");
	                    
	                    System.out.print("Titulo: ");
	                    titulo = sn.nextLine();
		                System.out.print("Autor(es) (en caso de múltiples autores, usa el ',' como delimitador): ");
		                autor = sn.nextLine();
		                System.out.print("ISBN: ");	                
		                isbn = sn.nextLine();
	                }
	                
	                if (!(titulo.equals(""))) {
	                	propFilter.add(titulo);
	                }
	                if (!(autor.equals(""))) {
	                	propFilter.add(autor);
	                }
	                if (!(isbn.equals(""))) {
	                	propFilter.add(isbn);
	                }	              
	                
	                List<List<String>> busqueda = find_book(libros, propFilter);
	                if (busqueda.isEmpty()) {
	                	System.out.println("\nTu búsqueda no arrojo resultados.");
	                }
	                else {
	                	System.out.println("\nSe encontraron resultados:\n");
	                	for (int indice = 0; indice < busqueda.size(); indice++) {
	                		System.out.println(busqueda.get(indice));
	                	}
	                }					
					break;
				case 3:
					int opcionEdicion = 0;
					boolean salirEdicion = false;
					List<List<String>> edicion = new ArrayList<>();
					System.out.println("\nEdición de registros de libros.\nEstos libros están registrados:");
					for (int i = 0; i < libros.size(); i++) {
						System.out.println((i+1)+". "+libros.get(i));
					}
					System.out.println("\nEscoge el número del libro que quieres editar: ");
					int libroEditado = sn.nextInt();
					while (libroEditado < 1 || libroEditado > libros.size()){
	                    System.out.print("\nEscoge una opción válida: ");
	                    libroEditado = sn.nextInt();
	                }
					libroEditado -= 1;
					while(!salirEdicion){
	                    System.out.println("\nLibro: "+(libros.get(libroEditado)).get(0)+"\n");

	                    System.out.println("1. Título");
	                    System.out.println("2. Autor");
	                    System.out.println("3. Año de edición");
	                    System.out.println("4. Número de páginas");
	                    System.out.println("5. Editorial");
	                    System.out.println("6. Género");
	                    System.out.println("7. ISBN");
	                    System.out.println("8. Ubicación");
	                    System.out.println("9. Estado");
	                    System.out.println("10. Descripción");
	                    System.out.println("11. Salir");
	                    System.out.println("");

	                    System.out.print("\nEscoge que deseas editar: ");
	                    opcionEdicion = sn.nextInt();
	                    String nuevaInfo;
	                    
	                    switch(opcionEdicion) {
	                    case 1:
	                        nuevaInfo = sn.nextLine();
	                        System.out.print("Título: ");
	                        nuevaInfo = sn.nextLine();

	                        while (nuevaInfo == ""){
	                            System.out.println("El libro debe poseer un título");
	                            System.out.print("Título: ");
	                            nuevaInfo = sn.nextLine();
	                        }
	                        edicion = edit_book(libros, libroEditado, opcionEdicion, nuevaInfo);
	                        System.out.println("\nTítulo editado\n");
	                        break;
	                        
	                    case 2:
	                        System.out.print("Autor(es) (en caso de múltiples autores, usa el ',' como delimitador): ");
	                        nuevaInfo = sn.nextLine();

	                        while (nuevaInfo == ""){
	                            System.out.println("El libro debe tener uno o más autores.");
	                            System.out.print("Autor(es) (en caso de múltiples autores, usa el ',' como delimitador): ");
	                            nuevaInfo = sn.nextLine();
	                        }
	                        edicion = edit_book(libros, libroEditado, opcionEdicion, nuevaInfo);
	                        System.out.println("\nAutores editados\n");
	                        break;
	                        
	                    case 3:
	                    	System.out.print("Fecha de edición: ");
	                        nuevaInfo = sn.nextLine();

	                        while (nuevaInfo == ""){
	                            System.out.println("El libro debe tener una fecha de edición.");
	                            System.out.print("Fecha de edición");
	                            nuevaInfo = sn.nextLine();
	                        }
	                        edicion = edit_book(libros, libroEditado, opcionEdicion, nuevaInfo);
	                        System.out.println("\nFecha de edición editada\n");
	                    	break;
	                    case 4:
	                        nuevaInfo = sn.nextLine();
	                    	System.out.print("Número de páginas: ");
	                        nuevaInfo = sn.nextLine();

	                        while (nuevaInfo == ""){
	                            System.out.println("El libro debe tener un número definido de páginas.");
	                            System.out.print("Número de páginas: ");
	                            nuevaInfo = sn.nextLine();
	                        }
	                        edicion = edit_book(libros, libroEditado, opcionEdicion, nuevaInfo);
	                        System.out.println("\nNúmero de páginas editado\n");
	                    	break;
	                    case 5:
	                    	System.out.print("Editorial: ");
	                        nuevaInfo = sn.nextLine();

	                        while (nuevaInfo == ""){
	                            System.out.println("El libro debe tener una editorial asociada.");
	                            System.out.print("Editorial");
	                            nuevaInfo = sn.nextLine();
	                        }
	                        edicion = edit_book(libros, libroEditado, opcionEdicion, nuevaInfo);
	                        System.out.println("\nEditorial editada\n");
	                    	break;
	                    case 6:
	                    	System.out.print("Género: ");
	                        nuevaInfo = sn.nextLine();

	                        while (nuevaInfo == ""){
	                            System.out.println("El libro debe pertenecer a un género literario.");
	                            System.out.print("Género");
	                            nuevaInfo = sn.nextLine();
	                        }
	                        edicion = edit_book(libros, libroEditado, opcionEdicion, nuevaInfo);
	                        System.out.println("\nGénero editado\n");
	                    	break;
	                    case 7:
	                    	System.out.print("ISBN: ");
	                        nuevaInfo = sn.nextLine();

	                        while (nuevaInfo == ""){
	                            System.out.println("El libro debe poseer un codigo ISBN.");
	                            System.out.print("ISBN: ");
	                            nuevaInfo = sn.nextLine();
	                        }
	                        edicion = edit_book(libros, libroEditado, opcionEdicion, nuevaInfo);
	                        System.out.println("\nCódigo ISBN editado\n");
	                    	break;
	                    case 8:               	
	                    	System.out.print("Ubicación (piso, pasillo, estante, (x;y)): ");
	                        nuevaInfo = sn.nextLine();
	                        String[] nuevaPosicion = nuevaInfo.split(",");
	                        
	                        //UN CAMBIO QUE SE PUEDE HACER ES QUE SE PERMITA CAMBIAR SOLO EL PISO, O SOLO EL ESTANTE, O SOLO EL PASILLO, ETC.
	                        while (nuevaInfo.isEmpty() || nuevaPosicion.length != 4){
	                        	System.out.println("Faltó algún dato o entregaste datos en formato incorrecto.");
	    	                    System.out.print("Ubicación (piso, pasillo, estante, (x;y)): ");
	                            nuevaInfo = sn.nextLine();
	                            nuevaPosicion = nuevaInfo.split(";");
	                        }
	                        edicion = edit_book(libros, libroEditado, opcionEdicion, nuevaInfo);
	                        System.out.println("\nUbicación editada\n");
	                    	break;
	                    case 9:                   	
	                    	System.out.print("Estado (Prestado, disponible, extraviado): ");
	                        nuevaInfo = sn.nextLine();
	                        nuevaInfo = nuevaInfo.toLowerCase();

	                        while (!(nuevaInfo.equals("prestado") || nuevaInfo.equals("disponible") || nuevaInfo.equals("extraviado"))){
	                            System.out.println("Estado inválido");
	                            System.out.print("Estado (Prestado, disponible, extraviado): ");
	                            nuevaInfo = sn.nextLine();
	                            nuevaInfo = nuevaInfo.toLowerCase();
	                        }
	                        edicion = edit_book(libros, libroEditado, opcionEdicion, nuevaInfo);
	                        System.out.println("\nEstado editado\n");
	                    	break;
	                    case 10:
	                    	System.out.print("Descripción: ");
	                        nuevaInfo = sn.nextLine();

	                        while (nuevaInfo == ""){
	                            System.out.println("El libro debe poseer una descripción.");
	                            System.out.print("Descripción: ");
	                            nuevaInfo = sn.nextLine();
	                        }
	                        edicion = edit_book(libros, libroEditado, opcionEdicion, nuevaInfo);
	                        System.out.println("\nDescripción editada\n");
	                    	break;
	                    case 11:
	                    	salirEdicion = true;
	                    	break;
	                    default:
	                    	System.out.println("Solo puedes ingresar números entre 1 y 11");
	                    }
	                    
		                if (!(edicion.isEmpty())){
		                    libros = new ArrayList<>(edicion);
		                }
					}
					break;
				case 4:
					if (libros.isEmpty()) {
						System.out.println("\nEl registro de libros esta vacío.\n");
					}
					else {
						System.out.println("\nBorrar registro de libro. Estos libros están registrados:\n");
						for (int i = 0; i < libros.size(); i++) {
							System.out.println((i+1)+". "+libros.get(i));
						}
						System.out.println("\nEscoge el número del libro que quieres eliminar: ");
						int libroBorrado = sn.nextInt();
						while (libroBorrado < 1 || libroBorrado > libros.size()){
		                    System.out.print("\nEscoge una opción válida: ");
		                    libroBorrado = sn.nextInt();
		                }
						libroBorrado -= 1;
						List<List<String>> remanente = delete_book(libros, libroBorrado);
						libros = new ArrayList<>(remanente);
						System.out.println("\nLibro eliminado del registro.\n");
					}		
					break;
				case 5:
					salir = true;
					break;
				default:
					System.out.println("Solo puedes ingresar números entre 1 y 5");
				}

			} catch (InputMismatchException e) {
				System.out.println("Debes indicar un número");
				sn.next();
			}
		}
	}
}
