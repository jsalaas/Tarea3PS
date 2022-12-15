package tarea3;

import java.util.*;

import org.junit.Assert;
import org.junit.Test;

public class BooksAppTesting {

	@Test
	public void testAdd_book() {
		List<List<String>> libros = BooksApp.load_books();
		List<List<String>> libros_a_comparar = BooksApp.load_books();
		
		List<String> libro = new ArrayList<>();
		libro.add ("Matemáticas Simplificadas");
        libro.add ("Conamat");
        libro.add ("2013");
        libro.add ("1614");
        libro.add ("Pearson Education");
        libro.add ("Matemática");
        libro.add ("9786073234269");
        libro.add ("2;2;B;(59,21)");
        libro.add ("Disponible");
        libro.add ("Compendio de Aritmética, Álgebra, Geometría, Trigonometría, Geometría analítica, Cálculo diferencial y Cálculo integral.");
        
        //Se añade a la fuerza el libro a lo que se espera que se obtenga del método en la clase BooksApp
        libros_a_comparar.add(libro);
        
        //Se invoca el método y se comppara si ambas listas son iguales.
        Assert.assertEquals(libros_a_comparar, BooksApp.add_book(libros, libro));
	}
	
	@Test
	public void testFind_titulo() {
		
		List<List<String>> libros = BooksApp.load_books();
        List<String> propFilter = new ArrayList<>();
        
        propFilter.add("Relatos de Sebastopol");
        
        List<List<String>> resultado_busq = new ArrayList<>();

        List<String> libro = new ArrayList<>();
        libro.add ("Relatos de Sebastopol");
        libro.add ("Leon Tolstoi");
        libro.add ("2013");
        libro.add ("216");
        libro.add ("Alba Editorial");
        libro.add ("Relato corto");
        libro.add ("9788484288978");
        libro.add ("2;1;D;(1,7)");
        libro.add ("Disponible");
        libro.add ("Tres relatos cortos que documentan las experiencias del autor durante el sitio de Sebastopol.");

        
        resultado_busq.add(libro);
        
		
		Assert.assertEquals(resultado_busq, BooksApp.find_book(libros, propFilter));
	}
	
	@Test
	public void testFind_autor() {
		
		List<List<String>> libros = BooksApp.load_books();
        List<String> propFilter = new ArrayList<>();
        
        propFilter.add("Leon Tolstoi");
        
        List<List<String>> resultado_busq = new ArrayList<>();

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

        
        resultado_busq.add(libro1);
        resultado_busq.add(libro2);
		
		Assert.assertEquals(resultado_busq, BooksApp.find_book(libros, propFilter));
	}
	
	@Test
	public void testFind_isbn() {
		
		List<List<String>> libros = BooksApp.load_books();
        List<String> propFilter = new ArrayList<>();
        
        propFilter.add("9788491054030");
        
        List<List<String>> resultado_busq = new ArrayList<>();

        List<String> libro = new ArrayList<>();
        libro.add ("El idiota");
        libro.add ("Fiodor Dostoievski");
        libro.add ("2019");
        libro.add ("766");
        libro.add ("Penguin Clásicos");
        libro.add ("Novela");
        libro.add ("9788491054030");
        libro.add ("1;6;A;(5,13)");
        libro.add ("Prestado");
        libro.add ("Es considerada de las novelas más brillantes por el autor ruso y de la 'Edad de Oro' en la literatura rusa.");

        
        resultado_busq.add(libro);
        
		Assert.assertEquals(resultado_busq, BooksApp.find_book(libros, propFilter));
	}
	
	@Test
	public void testFind_titulo_autor() {
		
		List<List<String>> libros = BooksApp.load_books();
        List<String> propFilter = new ArrayList<>();
        
        propFilter.add("Sonata a Kreutzer");
        propFilter.add("Leon Tolstoi");
        
        List<List<String>> resultado_busq = new ArrayList<>();

        List<String> libro = new ArrayList<>();
        libro.add ("Sonata a Kreutzer");
        libro.add ("Leon Tolstoi");
        libro.add ("2011");
        libro.add ("168");
        libro.add ("Acantilado");
        libro.add ("Novela");
        libro.add ("8496136280");
        libro.add ("1;3;B;(5,15)");
        libro.add ("Disponible");
        libro.add ("Su titulo es tomado de la composición homónima para violín y piano de Ludwig Van Beethoven.");
        
        
        resultado_busq.add(libro);
        
		
		Assert.assertEquals(resultado_busq, BooksApp.find_book(libros, propFilter));
	}
	
	@Test
	public void testFind_titulo_isbn() {
		
		List<List<String>> libros = BooksApp.load_books();
        List<String> propFilter = new ArrayList<>();
        
        propFilter.add("El idiota");
        propFilter.add("9788491054030");
        
        List<List<String>> resultado_busq = new ArrayList<>();

        List<String> libro = new ArrayList<>();
        libro.add ("El idiota");
        libro.add ("Fiodor Dostoievski");
        libro.add ("2019");
        libro.add ("766");
        libro.add ("Penguin Clásicos");
        libro.add ("Novela");
        libro.add ("9788491054030");
        libro.add ("1;6;A;(5,13)");
        libro.add ("Prestado");
        libro.add ("Es considerada de las novelas más brillantes por el autor ruso y de la 'Edad de Oro' en la literatura rusa.");
        
        
        resultado_busq.add(libro);
       
		Assert.assertEquals(resultado_busq, BooksApp.find_book(libros, propFilter));
	}
	
	@Test
	public void testFind_autor_isbn() {
		
		List<List<String>> libros = BooksApp.load_books();
        List<String> propFilter = new ArrayList<>();
        
        propFilter.add("Leon Tolstoi");
        propFilter.add("9788484288978");
        
        List<List<String>> resultado_busq = new ArrayList<>();

        List<String> libro = new ArrayList<>();
        libro.add ("Relatos de Sebastopol");
        libro.add ("Leon Tolstoi");
        libro.add ("2013");
        libro.add ("216");
        libro.add ("Alba Editorial");
        libro.add ("Relato corto");
        libro.add ("9788484288978");
        libro.add ("2;1;D;(1,7)");
        libro.add ("Disponible");
        libro.add ("Tres relatos cortos que documentan las experiencias del autor durante el sitio de Sebastopol.");
        
        
        resultado_busq.add(libro);
        
		Assert.assertEquals(resultado_busq, BooksApp.find_book(libros, propFilter));
	}
	
	@Test
	public void testFind_titulo_autor_isbn() {
		
		List<List<String>> libros = BooksApp.load_books();
        List<String> propFilter = new ArrayList<>();
        
        propFilter.add("Relatos de Sebastopol");
        propFilter.add("Leon Tolstoi");
        propFilter.add("9788484288978");
        
        List<List<String>> resultado_busq = new ArrayList<>();

        List<String> libro = new ArrayList<>();
        libro.add ("Relatos de Sebastopol");
        libro.add ("Leon Tolstoi");
        libro.add ("2013");
        libro.add ("216");
        libro.add ("Alba Editorial");
        libro.add ("Relato corto");
        libro.add ("9788484288978");
        libro.add ("2;1;D;(1,7)");
        libro.add ("Disponible");
        libro.add ("Tres relatos cortos que documentan las experiencias del autor durante el sitio de Sebastopol.");
        
        
        resultado_busq.add(libro);
        
		Assert.assertEquals(resultado_busq, BooksApp.find_book(libros, propFilter));
	}
	
	@Test
	public void testEdit_book() {
		
		List<List<String>> libros = BooksApp.load_books();
		List<List<String>> resultado = new ArrayList<>();
		List<List<String>> edicion = new ArrayList<>();
                
        List<String> libro1 = new ArrayList<>();
        libro1.add ("Sonata a Kreutzer");
        libro1.add ("Leon Tolstoi");
        libro1.add ("2011");
        libro1.add ("168");
        libro1.add ("Acantilado");
        libro1.add ("Novela");
        libro1.add ("8496136280");
        libro1.add ("1;3;B;(5,15)");
        libro1.add ("Prestado");
        libro1.add ("Su titulo es tomado de la composición homónima para violín y piano de Ludwig Van Beethoven.");
        
        List<String> libro2 = new ArrayList<>();
        libro2.add ("Relatos de Sebastopol");
        libro2.add ("Leon Tolstoi");
        libro2.add ("2010");
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
        libro3.add ("Cengage Learning");
        libro3.add ("Novela");
        libro3.add ("9788491054030");
        libro3.add ("1;6;A;(5,13)");
        libro3.add ("Disponible");
        libro3.add ("Es considerada de las novelas más brillantes por el autor ruso y de la 'Edad de Oro' en la literatura rusa.");
        
        resultado.add(libro1);
        resultado.add(libro2);
        resultado.add(libro3);
        
        edicion = BooksApp.edit_book(libros, 0, 9, "Prestado");
        edicion = BooksApp.edit_book(libros, 1, 3, "2010");
        edicion = BooksApp.edit_book(libros, 2, 5, "Cengage Learning");
        edicion = BooksApp.edit_book(libros, 2, 9, "Disponible");        
		
		Assert.assertEquals(resultado, edicion);
	}
	
	@Test
	public void testDelete_book() {
		
		List<List<String>> libros = BooksApp.load_books();
		List<List<String>> resultado = new ArrayList<>();
                
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
        libro2.add ("El idiota");
        libro2.add ("Fiodor Dostoievski");
        libro2.add ("2019");
        libro2.add ("766");
        libro2.add ("Penguin Clásicos");
        libro2.add ("Novela");
        libro2.add ("9788491054030");
        libro2.add ("1;6;A;(5,13)");
        libro2.add ("Prestado");
        libro2.add ("Es considerada de las novelas más brillantes por el autor ruso y de la 'Edad de Oro' en la literatura rusa.");
        
        resultado.add(libro1);
        resultado.add(libro2);
       
		Assert.assertEquals(resultado, BooksApp.delete_book(libros, 1));
	}

}
