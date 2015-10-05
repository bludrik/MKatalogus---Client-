package catalogue.logic;

import catalogue.GUI.CatalogueUI;
import catalogue.endpoint.DirectorItem;
import catalogue.endpoint.GenreItem;
import catalogue.endpoint.MovieItem;
import catalogue.endpoint.MovieSubItem;
import catalogue.endpoint.ReleaseItem;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Az alkalmazás logikai részét megvalósító osztály.
 * @author Ludrik Balazs
 */
public class CatalogueLogic {

    /**
     * A megjelenő ablak objektum
     */
    private CatalogueUI frame;
    /**
     * A filmek adatait megjelenítő tábla objektum
     */
    private JTable table;
    /**
     * Az filmeket tartalmazó lista
     */
    private List<MovieSubItem> moviesList;
    /**
     * Az rendezőket tartalmazó lista
     */
    private List<DirectorItem> directorsList;
    /**
     * Kiadási típusok listája.
     */
    private List<ReleaseItem> releasesList;
    /**
     * A műfajokat tartalmazó lista
     */
    private List<GenreItem> genresList;
    /**
     * A táblázat táblamodellje
     */
    private MovieTableModel model = null;
    /**
     * Timer a felhasználó képernyő törléséhez
     */
    private Timer timer = new Timer();

    public void setMoviesList(List<MovieSubItem> moviesList) {
        this.moviesList = moviesList;
    }

    public void setDirectorsList(List<DirectorItem> directorsList) {
        this.directorsList = directorsList;
    }

    public void setReleasesList(List<ReleaseItem> releasesList) {
        this.releasesList = releasesList;
    }

    public void setGenresList(List<GenreItem> genresList) {
        this.genresList = genresList;
    }

    
    
    /**
     * Visszaadja a kliens által ismert filmek listáját.
     * @return 
     */
    public List<MovieSubItem> getMoviesList() {
        return moviesList;
    }

    /**
     * Visszaadja a kliens által ismert kiadási típusok listáját.
     * @return 
     */
    public List<ReleaseItem> getReleasesList() {
        updateReleasesList();
        return releasesList;
    }

    /**
     * Visszaaadja a kliensnél megtalálható rendezők listáját
     * @return  rendezők listája
     */
    public List<DirectorItem> getDirectorsList() {
        updateDirectorsList();
        return directorsList;
    }
    
    /**
     * Visszaaadja a kliensnél megtalálható műfajok listáját
     * @return  rendezők listája
     */
    public List<GenreItem> getGenresList() {
        updateGenresList();
        return genresList;
    }
    
    /**
     * Visszadja a paraméterként kapott azonosítóval rendelkező rendező nevét.
     * @param id  a keresett rendező azonosítója
     * @return      a keresett rendező neve vagy null
     */
    public String getDirectorNamebyID(int id) {
        try {
            return getDirectorNameByIdService(id);
        }
        catch( Exception ex) {
            return null;
        }
    }
    
    /**
     * Visszadja a paraméterként kapott nevű rendező azonosítóját.
     * @param id    a keresett rendező neve
     * @return      a keresett rendező id-ja vagy null ha nincs ilyen rendező
     */
    public Integer getDirectorIDbyName(String name) {
        try{
            return getDirectorIdByNameService(name);
        } catch(Exception ex) {
            return null;
        }
    }
    
    /**
     * Vissza adja a paraméterben kapott nevű rendező adatait.
     * @param name  a keresett rendező neve
     * @return      a rendező adatait tartalmazó struktúra
     */
    public DirectorItem getDirectorByName(String name) {
        Iterator<DirectorItem> it = directorsList.iterator();
        DirectorItem director = null;
        while(it.hasNext()) {
            director = it.next();
            if( name.equals(director.getFirstname() + " " + director.getLastname()) ) {
                break;
            }
        }
        return director; 
    }
    
    /**
     * Visszadja a paraméterként kapott azonosítóval rendelkező kiadvány nevét.
     * @param azon  a keresett extra azonosítója
     * @return      a keresett extra neve
     */
    public String getReleaseNamebyID(Integer id) {
        try{
            return getReleaseNameByIdService(id);
        }
        catch(Exception ex) {
            return null;
        }
    }
    
    /**
     * Visszadja a paraméterként kapott azonosítóval rendelkező extra nevét.
     * @param azon  a keresett extra neve
     * @return      a keresett extra azonosítója vagy null
     */
    public Integer getReleaseIDbyName(String name) {
        try{
            return getReleaseIdByNameService(name);
        } catch(Exception ex) {
            return null;
        }
    }
    
    /**
     * Visszaadja a praméterben kapott indexű/sorszámú filmet.
     * @param idx   a kért film indexe a listában
     * @return      visszatérési értéke a film adatait tartalmazó MovieItem objektum
     */
    public MovieSubItem getMovie(int idx) {
        try {
            return moviesList.get(idx);
        } catch( IndexOutOfBoundsException ex) {
            return null;
        }
    }
    
    /**
     * Visszaadja a kliens által ismert filmek számát.
     * @return  a filmek darabszáma
     */
    public int getMoviesCount() {
        if( moviesList != null) {
            return moviesList.size();
        } else {
            return 0;
        }
    }
    
    /**
     * CatalogueLogic konstruktora
     * @param frame a GUI felületetet reprezentáló objektum
     */
    public CatalogueLogic(CatalogueUI frame) {
        this.frame = frame;
      
        sendMsgToUser("Filmek betöltése...", Color.GRAY);
        populateTable();
        sendMsgToUser("", Color.GRAY);
        
    }
    
    /**
     * Feltölti az alkalmazás által használt listákat a katalógusban tárolt adatokkal.
     * Ilyen listák: film, rendező, műfaj, kiadási típus listák
     * 
     */
    private void populateTable() {
       
        moviesList = getMoviesService();
        directorsList = getDirectorsService();
        releasesList = getReleasesService();
        updateGenresList();
          
    }
    
    /**
     * Lekérdezi a rendezők listájának legfrissebb változatát a távoli katalógusból.
     */
    public void updateDirectorsList() {
        directorsList = getDirectorsService();
        
    }
    
    /**
     * Lekérdezi a filmek listájának legfrissebb változatát a távoli katalógusból.
     */
    public void updateMoviesList() {
        moviesList = getMoviesService();
    }
    
    /**
     * Lekérdezi a műfajok listájának legfrissebb változatát a távoli katalógusból.
     */
    public void updateGenresList() {
        genresList = getGenresService();
    }
    
    /**
     * Lekérdezi a kiadási típusok listájának legfrissebb változatát a távoli katalógusból.
     */
    public void updateReleasesList() {
        releasesList = getReleasesService();
    }
    
    /**
     * Jelzi a figyelőknek a filmeket tartalmazó táblázat módosulását.
     */
    public void fireMovieTableDataChanged() {
        if(model == null) {
            model = frame.getModel();
        }
        try {
            model.updateTable();
        } catch(IndexOutOfBoundsException ex) {
            //túlindexelés 
//            System.out.println("ex:" + ex);
        } catch( NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Üres lista", "Üres lista.", JOptionPane.INFORMATION_MESSAGE);
        } catch( Exception ex) {
        
        }
    }
    
    /**
     * Táblázatba való filmbeszúrás esetén frissíti a táblázatot az újonnan hozzáadott filmmel.
     */
    public void fireTableRowsInserted() {
        if(model == null) {
            model = frame.getModel();
        }
        try {
            model.updateTable();
        } catch( Exception ex) {
        
        }
    }

    /**
     * Felépít egy MovieItem objektumot és azt elmenti a távoli katalógusba.
     * 
     * @param titleHU   film címe
     * @param year      film készítési ideje
     * @param titleEN   film címe angolul
     * @param directors  film rendezője
     * @param release     film kiadási típusa
     * @param genres    film műfaja
     * @param type      film formátuma (DVD v. Blue-ray)
     */
    public void insertMovie(String titleHU, String titleOrig, Integer year, List<String> directors, String release, String type, String imdbId, List<String> genres, Integer amount) {
       
        sendMsgToUser("Film hozzáadása...", Color.gray);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String time = sdf.format( Calendar.getInstance().getTime());

            MovieItem item = new MovieItem();
            item.setTitleHu(titleHU);
            item.setTitleOrig(titleOrig);
            item.setYear( year );
            Integer releaseId = getReleaseIDbyName(release);
            if( releaseId == null) {
                JOptionPane.showMessageDialog(frame, "Nincs megfelelő kiadvány beállítva","Nincs kiadvány", JOptionPane.WARNING_MESSAGE);
                sendMsgToUser("", Color.gray);
                return;
            }
            item.setReleaseid(releaseId);
            item.setType(type);
            item.setImdbUrl("http://www.imdb.com/title/"+imdbId);
            item.setAmount(amount);
            
            //rendezők azonosítói
            ArrayList<Integer> directorIdx = new ArrayList<>();
            for( int i=0; i<directors.size(); i++ ) {
                Integer id = getDirectorIDbyName(directors.get(i) );
                if( id != null) {
                    directorIdx.add(id);
                }
            }
            
            //műfajok azonosítói
            ArrayList<Integer> genreIdx = new ArrayList<>();
            for( int i=0; i<genres.size(); i++ ) {
                Integer id = getGenreIdByName(genres.get(i) );
                if( id != null) {
                    genreIdx.add(id);
                }
            }
            
            
           String response = insertMovieService(item, genreIdx, directorIdx);
           //System.out.println("response: "+response);
           if( response.contains("SQLEX")) {
               if( response.contains("SQLIntegrityConstraintViolationException")) {
                   sendMsgToUser("[ "+time+" - A film hozzáadásakor hiba lépett fel, így bizonyos adatok lehet nem kerültek elmentésre ]", Color.red);
               } else {
                   sendMsgToUser("[ "+time+" - A film hozzáadása sikertelen. Ellenőrizze, hogy helyesen töltötte-e ki az űrlapot! ]", Color.red);
               }
           } else if( response.equals("0") ) {
               sendMsgToUser("[ "+time+" - A film hozzáadása sikertelen. ]", Color.red);
           } else {
               
               sendMsgToUser("[ "+time+" - A film hozzáadása sikeres ]", Color.gray);
               
           }
           updateMoviesList();
           fireTableRowsInserted();
            
        
    }
    
    /**
     * Összeállít egy DirectorItem(Rendező) objektumot és elmenti a távoli katalógusba.
     * 
     * @param lName         rendező keresztneve
     * @param fName         rendező vezetékneve
     * @param birth         rendező születési ideje
     * @param birthPlace    rendező születési helye
     */
    public void insertDirector(String lName, String fName, XMLGregorianCalendar birth, String birthPlace) {
        DirectorItem director = new DirectorItem();
            
            director.setId( 0 );
            director.setLastname(lName);
            director.setFirstname(fName);
            director.setBirth(birth);
            director.setBirthplace(birthPlace);

            String response = insertDirectorService(director);            
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            String time = sdf.format(Calendar.getInstance().getTime());
            //Sikeresség ellenőrzése
            if( response.equals("0")) {
                sendMsgToUser("[ "+ time + " - " +director.getFirstname()+" "+director.getLastname()+" felvétele sikertelen ]", Color.red);
            } else if (response.contains("SQLEX")) {
                sendMsgToUser("[ "+ time + " - " +director.getFirstname()+" "+director.getLastname()+" felvétele sikertelen." + response.substring(7) +" ]", Color.red);
                System.out.println(response.substring(7));
            } else {
                updateDirectorsList();
                sendMsgToUser("[ "+ time + " - " + director.getFirstname()+" "+director.getLastname()+" felvétele sikeres ]", Color.gray);
            }

    }   
   
    /**
     * A felhasználó által egy film bejegyzésen végzett módosításokat a távoli katalógusba menti.
     * @param key                   módosított film bejegyzés kulcsa
     * @param movie                 módosított film bejegyzés
     * @param modifiedGenreIdx      módosított filmhez tartozó műfajok
     * @param modifiedDirectorIdx   módosított filmhez tartozó rendezők
     */
    public void updateMoviesTable( int key, MovieItem movie, List<String> genres, List<String> directors) {
        sendMsgToUser("Film frissítése...", Color.gray);
        //rendezők azonosítói
            ArrayList<Integer> directorIdx = new ArrayList<>();
            for( int i=0; i<directors.size(); i++ ) {
                Integer id = getDirectorIDbyName(directors.get(i) );
                if( id != null) {
                    directorIdx.add(id);
                }
            }
            
            //műfajok azonosítói
            ArrayList<Integer> genreIdx = new ArrayList<>();
            for( int i=0; i<genres.size(); i++ ) {
                Integer id = getGenreIdByName(genres.get(i) );
                if( id != null) {
                    genreIdx.add(id);
                }
//                genreIdx.add(new Integer(getGenreIdByName(genres.get(i) )));
            }
        
        String response = updateMovieService(key, movie, genreIdx, directorIdx );          
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String time = sdf.format(Calendar.getInstance().getTime());
        String title = movie.getTitleHu();
        //Sikeresség ellenőrzése
        if( response.equals("0")) {
            sendMsgToUser("[ "+ time + " - " + title +" módosítása sikertelen ]", Color.red);
        } else if (response.contains("SQLEX")) {
//            if( response.contains("SQLIntegrityConstraintViolationException")) {
//                   sendMsgToUser("[ "+time+" - "+title+" módosítása sikertelen ]", Color.red);
//               } else {
                   sendMsgToUser("[ "+ time + " - " + title +" módosítása sikertelen" /*+ response.substring(7)*/ +" ]", Color.red);
//               }
            
        } else {
            updateMoviesList(); //frissíti a listát katalógusból
            fireMovieTableDataChanged();    //szól a táblázat figyelőinek
            sendMsgToUser("[ "+ time + " - " + title +" módosítása sikeres ]", Color.gray);
        }        
        
    }

    /**
     * Üzenetet küld a felhasználónak, amit a kapcsolattartó falon jelenít meg.
     * @param str   az üzenet szövege
     * @param c     az üzenet színe
     */
    public void sendMsgToUser(String str, Color c) {
        frame.setUserMsg(str, c);
    }
   

    /**
     * Egy rendező módosítását végzi a távoli katalógusban.
     * 
     * @param oldID         módosítandó rendező id-ja
     * @param fName         módosított keresztnév
     * @param lName         módosított vezetéknév
     * @param birth         módosított születési dátum
     * @param birthPlace    módosított születési hely
     */
    public void updateDirector(int oldID, String fName, String lName, XMLGregorianCalendar birth, String birthPlace) {
        sendMsgToUser("Rendező frissítése...", Color.gray);
        DirectorItem directorObj = new DirectorItem();
            
        directorObj.setId( oldID );
        directorObj.setLastname(lName);
        directorObj.setFirstname(fName);
        directorObj.setBirth(birth);
        directorObj.setBirthplace(birthPlace);

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String time = sdf.format(Calendar.getInstance().getTime());            
        String response = updateDirectorService(oldID, directorObj);
        if( response.equals("0") || response.contains("SQLEX") ) {
            frame.setUserMsg("[ "+ time + " - " + directorObj.getFirstname() + " " + directorObj.getLastname() + " adatainak módosítása sikertelen ]", Color.red);
        } else {
            updateDirectorsList();
//            updateMoviesList();
            frame.setUserMsg("[ "+ time + " - " + directorObj.getFirstname() + " " + directorObj.getLastname() + " adatainak módosítása sikeres ]", Color.gray);
        }
    
    }

    /**
     * Visszaadja a kliens által ismert rendezők számát.
     * @return  egy egész érték, a jelenleg ismert rendezők száma
     */
    public int getDirectorsCount() {
        if( directorsList != null) {
            return directorsList.size();
        } else {
            return 0;
        }
    }
    
    /**
     * Visszaadja a kliens által ismert műfajok számát.
     * @return egy egész érték, a jelenleg ismert műfajok száma
     */
    public int getGenresCount() {
        if( directorsList != null) {
            return genresList.size();
        } else {
            return 0;
        }
    }

    /**
     * Visszaadja a kliens által ismert kiadási típusok számát.
     * @return egy egész érték, a jelenleg ismert kiadási típusok száma
     */
    public int getReleasesCount() {
        if( releasesList != null) {
            return releasesList.size();
        } else {
            return 0;
        }
    }

    /**
     * Lekérdezi a paraméterként kapott című filmeket. Azon filmeket is lekérdezi amelyek tartalmazzák a paraméterként kapott stringet.
     * @param searchText    a keresett film címe vagy címének egy részlete
     */
    public void getMoviesFilteredByName(String searchText) {
        moviesList = getMoviesFilteredByTitleService( searchText.toLowerCase() );
        fireMovieTableDataChanged();
    }

    /**
     * Elvégzi a rendező alapján való keresést. Használja a megfelelő web-servicet és jelzi a figyelőknek a filmeket tartalmazó táblázat frissülését.
     * @param searchText    keresett rendező
     */
    public void getMoviesFilteredByDirector(String searchText) {
        moviesList = getMoviesFilteredByDirectorService(searchText);
        fireMovieTableDataChanged();
    }
    
    /**
     * Elvégzi a műfaj alapján való keresést. Használja a megfelelő web-servicet és jelzi a figyelőknek a filmeket tartalmazó táblázat frissülését.
     * @param searchText keresett műfaj
     */
    public void getMoviesFilteredByGenre(String searchText) {
        moviesList = getMoviesFilteredByGenreService(searchText);
        fireMovieTableDataChanged();
    }

    /**
     * Elvégzi az adathordozó alapján való keresést. Használja a megfelelő web-servicet és jelzi a figyelőknek a filmeket tartalmazó táblázat frissülését.
     * @param searchText    keresett adathordozó
     */
    public void getMoviesFilteredByType(String searchText) {
        moviesList = getMoviesFilteredByTypeService(searchText);
        fireMovieTableDataChanged();
    }

    /**
     * Elvégzi a táblázatban kijelölt filmek törlését. Ehhez web-service hívást használ.
     * A művelet siekrességéről értesíti a felhasználót.
     * @param toDelete  törölni kívánt filmek sorszámait tartalmazó tömb
     */
    public void deleteMovies(int[] toDelete) {
        sendMsgToUser("Film(ek) eltávolítása...", Color.gray);
        List<Integer> keys = new ArrayList<>();
        //a törlendő filmek listájának összeállítása
        for(int i = 0; i<toDelete.length; i++ ) {
            keys.add(moviesList.get( toDelete[i] ).getId());
        }
        
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String time = sdf.format(Calendar.getInstance().getTime());            
        String response = deleteMoviesService(keys);
//        System.out.println("Response[Delete]: "+response);
        if( response.equals("0")) {
                sendMsgToUser("[ "+ time + " - A kijelölt film(ek) törlése sikertelen ]", Color.red);
            } else if (response.contains("SQLEX")) {
                sendMsgToUser("[ "+ time + " - Hiba lépett fel a törlés során, így egyes filmek törlése nem járt sikerrel " /*+ response.substring(7)*/ +" ]", Color.red);
            } else {
                updateMoviesList();
                fireMovieTableDataChanged();
                sendMsgToUser("[ "+ time + " - A kijelölt film(ek) törlése sikeres ]", Color.gray);
            }   
    }


    

    /**
     * A paraméterben kapott nevű rendezőket keresi meg.
     * @param name  keresett rendező neve
     */
    public void filterDirectors(String name) {
        directorsList = getDirectorsFilteredByNameService(name);
    }

    /**
     * Visszaadja a meghatározott sorszámú rendező objektumot.
     * @param rowIndex      a kért rendező sorszáma
     * @return              rendező objektum
     */
    DirectorItem getDirector(int rowIndex) {
        return directorsList.get(rowIndex);
    }

    /**
     * Elvégzi a paraméterben kapott sorszámú rendezők törlését.
     * @param toDelete  törlendő rendezők sorszáma
     */
    public void deleteDirectors(int[] toDelete) {
            sendMsgToUser("Rendező(k) törlése...", Color.GRAY);
            
            List<Integer> keys = new ArrayList<Integer>();
            //a törlendő rendezők listájának összeállítása
            for(int i = 0; i<toDelete.length; i++ ) {
                keys.add( directorsList.get(toDelete[i]).getId() );
            }
            //Törlés szolgáltatás hívása
            String response = deleteDirectorsService(keys);

            
            //Felhasználó tájékoztatása
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            String time = sdf.format( Calendar.getInstance().getTime() );
            if( response.equals("0") ) {
                sendMsgToUser("[ "+ time + " - " +"Hiba történt a kijelölt mezők törlésekor. ]", Color.red); 
            }
            else if( response.contains("SQLEX") ) {
                if( response.contains("ORA-02292")) {
                    sendMsgToUser("[ "+ time + " - " +"Hiba történt a rendező(k) törlésekor / Megeshet, hiogy olyan rendező(ke)t próbált törölni, amely(ek)re hivatkoznak ]", Color.red);
                } else {
                    sendMsgToUser("[ "+ time + " - " +"Hiba történt, így bizonyos rendező(k) törlése sikertelen  ]", Color.red);
                }
                updateDirectorsList();
            }
            else {
                sendMsgToUser("[ "+ time + " - " +"A kijelölt rendezők törlése sikeresen megtörtént ]", Color.GRAY);
                updateDirectorsList();
            }
            
    }

    /**
     * Új kiadási típust vesz fel a katalógusba.
     * @param name  kiadási típus neve
     */
    public void insertRelease( String name ) {
        sendMsgToUser("Kiadvány hozzáadása...", Color.gray);
        
        String response = insertReleaseService(name);
            
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String time = sdf.format(Calendar.getInstance().getTime());
        //Sikeresség ellenőrzése
        if( response.equals("0") ) {
            JOptionPane.showMessageDialog(frame, "Kiadás felvétele sikertelen", "Kiadási típus", JOptionPane.ERROR_MESSAGE);
            sendMsgToUser("[ "+ time + " - Kiadási típus: " +name+" felvétele sikertelen ]", Color.red);
        } else if (response.contains("SQLEX")) {
            JOptionPane.showMessageDialog(frame, "Kiadás felvétele sikertelen", "Kiadási típus", JOptionPane.ERROR_MESSAGE);
            sendMsgToUser("[ "+ time + " - Kiadási típus: " +name+" felvétele sikertelen."+ response.substring(7) +" ]", Color.red);
        } else if(response.contains("ERR")) {
            JOptionPane.showMessageDialog(frame, "Kiadás felvétele sikertelen. A típus már szerepel a katalógusban", "Kiadási típus", JOptionPane.ERROR_MESSAGE);
            sendMsgToUser("[ "+ time + " - Kiadási típus: " +name+" felvétele sikertelen ]", Color.red);
        } else {
            updateReleasesList();
            JOptionPane.showMessageDialog(frame, "Kiadás felvétele sikeres", "Kiadási típus", JOptionPane.INFORMATION_MESSAGE);
            sendMsgToUser("[ "+ time + " - Kiadási típus: " + name+" felvétele sikeres ]", Color.gray);
        }
    }

    
    /**
     * Kiadási típust töröl a katalógusból.
     * @param name  kiadási típus neve
     */
    public void deleteRelease(String name) {
        sendMsgToUser("Kiadvány eltávolítása...", Color.gray);
        Integer id = getReleaseIDbyName(name);
        if( id == null) {
            JOptionPane.showMessageDialog(frame, "Nincs megfelelő kiadvány beállítva","Nincs kiadvány", JOptionPane.WARNING_MESSAGE);
            sendMsgToUser("", Color.gray);
            return;
        }
        String response = deleteReleaseService(id);    
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String time = sdf.format(Calendar.getInstance().getTime());
        //Sikeresség ellenőrzése
        if( response.equals("0") ) {
            sendMsgToUser("[ "+ time + " - Kiadási típus: " +name+" törlése sikertelen ]", Color.red);
        } else if (response.contains("SQLEX")) {
            sendMsgToUser("[ "+ time + " - Kiadási típus: " +name+" törlése sikertelen / Nézze meg nem hivatkozik-e film a törlendős kiadványra"+ /*response.substring(7) +*/" ]", Color.red);
        } else {
            updateReleasesList();
            sendMsgToUser("[ "+ time + " - Kiadási típus: " + name+" törlése sikeres ]", Color.gray);
        }
        
    }

    /**
     * Kiadási típus módosítását végzi.
     * @param oldName   kiadási típus azonosítására használt, régi név
     * @param newName   új, már módosított név
     */
    public void updateRelease(String oldName, String newName) {
        sendMsgToUser("Kiadvány módosítása...", Color.gray);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String time = sdf.format(Calendar.getInstance().getTime());
        String response = "";
        Integer id = getReleaseIDbyName(oldName);
        if( id == null) {
            JOptionPane.showMessageDialog(frame, "Nincs megfelelő kiadvány beállítva","Nincs kiadvány", JOptionPane.WARNING_MESSAGE);
            //nem találta meg a kiadványt a listában
            response = ""+0;
        } else {
            response = updateReleaseService(id, newName);
        }
        if( response.equals("0") ) {
            sendMsgToUser("[ "+ time + " - Kiadási típus: " +oldName+" módosítása '" + newName +"'-ra sikertelen ]", Color.red);
        } else if(response.contains("ERR")) {
            sendMsgToUser("[ "+ time + " - Kiadási típus: " +oldName+" módosítása '" + newName +"'-ra sikertelen / Névegyezés már meglévő elemmel ]", Color.red);
        } else if (response.contains("SQLEX")) {
            sendMsgToUser("[ "+ time + " - Kiadási típus: " +oldName+" módosítása '" + newName +"'-ra sikertelen."/*+ response.substring(7)*/ +" ]", Color.red);
        } else {
           updateReleasesList();
            sendMsgToUser("[ "+ time + " - Kiadási típus: " +oldName+" módosítása '" + newName +"'-ra sikeres ]", Color.gray);
        }
    }

    /**
     * Az paraméterként kapott műfajt elmenti a távoli katalógusba.
     * @param name  műfaj neve
     */
    public void insertGenre(String name) {
        sendMsgToUser("Műfaj hozzáadása...", Color.gray);
        String response = insertGenreService(name);     
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String time = sdf.format(Calendar.getInstance().getTime());
        //Sikeresség ellenőrzése
        if( response.equals("0") ) {
            JOptionPane.showMessageDialog(frame, "Műfaj hozzáadása sikertelen", "Műfaj hozzáadása", JOptionPane.ERROR_MESSAGE);
            sendMsgToUser("[ "+ time + " - Műfaj: " +name+" felvétele sikertelen ]", Color.red);
        } else if(response.contains("ERR")) {
            JOptionPane.showMessageDialog(frame, "Műfaj felvétele sikertelen. A műfaj már szerepel a katalógusban", "Műfaj felvétele", JOptionPane.ERROR_MESSAGE);
            sendMsgToUser("[ "+ time + " - Műfaj: " +name+" felvétele sikertelen ]", Color.red);
        } else if (response.contains("SQLEX")) {
            if( response.contains("SQLIntegrityConstraintViolationException")) {
                JOptionPane.showMessageDialog(frame, "Műfaj hozzáadása sikertelen. A hozzáadni kívánt műfaj már szerepel a katalógusban.", "Műfaj hozzáadása", JOptionPane.ERROR_MESSAGE);
                sendMsgToUser("[ "+ time + " - Műfaj: " +name+" felvétele sikertelen / Ellenőrizze nincs-e már a listában a menteni kívánt műfaj!"+ /*response.substring(7)+*/" ]", Color.red);
            }
        } else {
            updateGenresList();
            JOptionPane.showMessageDialog(frame, "Műfaj felvétele sikeres.", "Műfaj hozzáadása", JOptionPane.INFORMATION_MESSAGE);
            sendMsgToUser("[ "+ time + " - Műfaj: " +name+" felvétele sikeres ]", Color.gray);
        }
    }

    /**
     * Törli a paraméterként kapott műfajt a katalógusból.
     * @param name  műfaj neve
     * @return      sikerességet igazoló egész, 1 ha sikeres a törlés, 0 ha nem
     */
    public int deleteGenre(String name) {
        sendMsgToUser("Műfaj eltávolítása...", Color.GRAY);
        Integer id = getGenreIdByName(name);
        if( id == null) {
            JOptionPane.showMessageDialog(frame, "Nincs megfelelő műfaj beállítva","Nincs műfaj megadva", JOptionPane.WARNING_MESSAGE);
            sendMsgToUser("", Color.GRAY);
            return 0;
        }
        String response = deleteGenreService(id);    
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String time = sdf.format(Calendar.getInstance().getTime());
        //Sikeresség ellenőrzése
        if( response.equals("0")) {
            JOptionPane.showMessageDialog(frame, "Sikertelen törlés", "Törlés", JOptionPane.ERROR_MESSAGE);
            sendMsgToUser("[ "+ time + " - Műfaj: " +name+" törlése sikertelen. ]", Color.red);
        } else if (response.contains("SQLEX")) {
            JOptionPane.showMessageDialog(frame, "Sikertelen törlés", "Törlés", JOptionPane.ERROR_MESSAGE);
            sendMsgToUser("[ "+ time + " - Műfaj: " +name+" törlése sikertelen / Lehetséges, hogy egyes filmek hivatkoznak a műfajra "+ /*response.substring(7) */" ]", Color.red);
        } else {
            updateGenresList();
            JOptionPane.showMessageDialog(frame, "Sikeres törlés", "Törlés", JOptionPane.INFORMATION_MESSAGE);
            sendMsgToUser("[ "+ time + " - Műfaj: " +name+" törlése sikeres. ]", Color.gray);
            return 1;
        }
        
        return 0;
    }
    
    /**
     * A paraméterek alapján módosít egy műfajt.
     * @param oldName   műfaj régi neve
     * @param newName   műfaj új neve
     */
    public void updateGenre(String oldName, String newName) {
        sendMsgToUser("Műfaj módosítása...", Color.gray);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String time = sdf.format(Calendar.getInstance().getTime());
        String response = "";
        Integer id = getGenreIdByName(oldName);
        if( id == null) {
            //nincs ilyen műfaj
            JOptionPane.showMessageDialog(frame, "Nincs megfelelő műfaj beállítva","Nincs műfaj megadva", JOptionPane.WARNING_MESSAGE);
            response = ""+0;
        } else {
            response = updateGenreService(id, newName);
        }
        
        if( response.equals("0") ) {
            sendMsgToUser("[ "+ time + " - Műfaj: " +oldName+" módosítása '" + newName +"'-ra sikertelen ]", Color.red);
        } else if(response.contains("ERR")) {
            sendMsgToUser("[ "+ time + " - Műfaj: " +oldName+" módosítása '" + newName +"'-ra sikertelen / Névegyezés már meglévő elemmel ]", Color.red);
        } else if (response.contains("SQLEX")) {
            sendMsgToUser("[ "+ time + " - Műfaj: " +oldName+" módosítása '" + newName +"'-ra sikertelen."/*+ response.substring(7)*/ +" ]", Color.red);
        } else {
           updateGenresList();
           sendMsgToUser("[ "+ time + " - Műfaj: " +oldName+" módosítása '" + newName +"'-ra sikeres ]", Color.gray);
        }
    }
    
    /**
     * Visszaadja a paraméterként kapott kulccsal rendelkező filmet.
     * @param key   kulcs
     * @return      film
     */
    public MovieItem getMovieByKey(int key) {
        return getMovieByKeyService(key);
    }
    
    
    /**
     * Visszadja a paraméterként kapott nevű műfaj azonosítóját.
     * @param id    a keresett műfaj neve
     * @return      a keresett műfaj id-ja vagy null ha nincs ilyen műfaj
     */
    public Integer getGenreIdByName(String name) {
        try{
            return getGenreIdByNameService(name);
        } catch(Exception ex) {
            return null;
        }
    }

    /**
     * Visszadja a paraméterként kapott azonosítóval rendelkező műfaj nevét.
     * @param id    azonostó   
     * @return      műfaj neve vagy null
     */
    public String getGenreNameById(Integer id) {
        try{
            return getGenreNameByIdService(id);
        } catch(Exception ex) {
            return null;
        }
    }
    
    /**
     * Visszaadja a paraméterben kapott azonosítóval rendelkező film rendezőit.
     * @param movieId
     * @return 
     */
    public List<Integer> getDirectorOfMovie(int movieId) {
        return getDirectorOfMovieService(movieId);
    }

    /**
     * Visszaadja a paraméterben kapott azonosítóval rendelkező film műfajait.
     * @param movieId
     * @return 
     */
    public List<Integer> getGenreOfMovie(int movieId) {
        return getGenreOfMovieService(movieId);
    }
    
    //
    // Web-service hívások:
    //
    
    /**
     * Web-service, mely visszaadja a Katalógusban szereplő összes filmet.
     * @return  MovieItemek listája
     */
    private static java.util.List<catalogue.endpoint.MovieSubItem> getMoviesService() {
        catalogue.endpoint.CatalogueService_Service service = new catalogue.endpoint.CatalogueService_Service();
        catalogue.endpoint.CatalogueService port = service.getCatalogueServicePort();
        return port.getMoviesService();
    }
    
    /**
     * Web-service, mely visszaadja a Katalógusban szereplő adott rendezőtől származó filmeket.
     * @param directorName      keresett rendező neve, részneve
     * @return                  MovieItemek listája
     */
    private static java.util.List<catalogue.endpoint.MovieSubItem> getMoviesFilteredByDirectorService(java.lang.String directorName) {
        catalogue.endpoint.CatalogueService_Service service = new catalogue.endpoint.CatalogueService_Service();
        catalogue.endpoint.CatalogueService port = service.getCatalogueServicePort();
        return port.getMoviesFilteredByDirectorService(directorName);
    }

    /**
     * Web-service, mely visszaadja a Katalógusban szereplő összes rendezőt.
     * @return  DirectorDatak listája
     */
    private static java.util.List<catalogue.endpoint.DirectorItem> getDirectorsService() {
        catalogue.endpoint.CatalogueService_Service service = new catalogue.endpoint.CatalogueService_Service();
        catalogue.endpoint.CatalogueService port = service.getCatalogueServicePort();
        return port.getDirectorsService();
    }

    /**
     * Web-service, mely törli a Katalógusból a paraméterként megadott kulcsú filmeket.
     * @param pKeys     a törlendő filmekhez tartozó kulcsok, MovieItemPK-k listája
     * @return          a sikeresen törölt sorok száma
     */
    private static String deleteMoviesService(java.util.List<Integer> pKeys) {
        catalogue.endpoint.CatalogueService_Service service = new catalogue.endpoint.CatalogueService_Service();
        catalogue.endpoint.CatalogueService port = service.getCatalogueServicePort();
        return port.deleteMoviesService(pKeys);
    }

    /**
     * Web-service, mely visszaadja a Katalógusban szereplő adott műfajú filmeket.
     * @param genre     keresett műfaj neve vagy részneve
     * @return          MovieItemek listája
     */
    private static java.util.List<catalogue.endpoint.MovieSubItem> getMoviesFilteredByGenreService(java.lang.String genre) {
        catalogue.endpoint.CatalogueService_Service service = new catalogue.endpoint.CatalogueService_Service();
        catalogue.endpoint.CatalogueService port = service.getCatalogueServicePort();
        return port.getMoviesFilteredByGenreService(genre);
    }

    /**
     * Web-service, mely visszaadja a Katalógusban szereplő adott című filmeket.
     * @param title     keresett film címe vagy részcíme
     * @return          MoviItemek listája    
     */
    private static java.util.List<catalogue.endpoint.MovieSubItem> getMoviesFilteredByTitleService(java.lang.String title) {
        catalogue.endpoint.CatalogueService_Service service = new catalogue.endpoint.CatalogueService_Service();
        catalogue.endpoint.CatalogueService port = service.getCatalogueServicePort();
        return port.getMoviesFilteredByTitleService(title);
    }

    /**
     * Web-service, mely visszaadja a Katalógusban szereplő adott adathordozón tárolt filmeket.
     * @param type      adathordozó típusa
     * @return          MoviItemek listája
     */
    private static java.util.List<catalogue.endpoint.MovieSubItem> getMoviesFilteredByTypeService(java.lang.String type) {
        catalogue.endpoint.CatalogueService_Service service = new catalogue.endpoint.CatalogueService_Service();
        catalogue.endpoint.CatalogueService port = service.getCatalogueServicePort();
        return port.getMoviesFilteredByTypeService(type);
    }

    /**
     * Web-service, mely új rendezőt ad hozzá a Katalógushoz.
     * @param director  új rendező adatai, DirectorData típus
     * @return          szöveges visszaigazolás
     */
    private static String insertDirectorService(catalogue.endpoint.DirectorItem director) {
        catalogue.endpoint.CatalogueService_Service service = new catalogue.endpoint.CatalogueService_Service();
        catalogue.endpoint.CatalogueService port = service.getCatalogueServicePort();
        return port.insertDirectorService(director);
    }

    /**
     * Web-service, mely új filmet ad hozzá a Katalógushoz.
     * @param movie     új film adatai, MovieItem típus
     * @return          sikerességet jellemző string
     */
    private static String insertMovieService(catalogue.endpoint.MovieItem movie, ArrayList<Integer> genreIdx, ArrayList<Integer> directorIdx) {
        catalogue.endpoint.CatalogueService_Service service = new catalogue.endpoint.CatalogueService_Service();
        catalogue.endpoint.CatalogueService port = service.getCatalogueServicePort();
        return port.insertMovieService(movie, genreIdx, directorIdx);
    }

    /**
     * Web-service, mely frissít egy rendező bejegyzést a Katalógusban.
     * @param id        frissítendó rendező azonosítója, egész érték
     * @param director  az új adatok, DirectorData objektum
     * @return          
     */
    private static String updateDirectorService(java.lang.Integer id, catalogue.endpoint.DirectorItem director) {
        catalogue.endpoint.CatalogueService_Service service = new catalogue.endpoint.CatalogueService_Service();
        catalogue.endpoint.CatalogueService port = service.getCatalogueServicePort();
        return port.updateDirectorService(id, director);
    }
    
    /**
     * Web-service, mely módosít egy film bejegyzést a Katalógusban.
     * @param condition       módosítandó film azonosítója
     * @param modifiedItem    módosított értékek
     * @return              
     */
    private static String updateMovieService(java.lang.Integer id, catalogue.endpoint.MovieItem modifiedItem, ArrayList<Integer> modifiedGenreIdx, ArrayList<Integer> modifiedDirectorIdx) {
        catalogue.endpoint.CatalogueService_Service service = new catalogue.endpoint.CatalogueService_Service();
        catalogue.endpoint.CatalogueService port = service.getCatalogueServicePort();
        return port.updateMovieService(id, modifiedItem, modifiedGenreIdx, modifiedDirectorIdx);
    }

    /**
     * Web-service, mely visszaadja a Katalógusban szereplő adott nevű rendezőt, rendezőket.
     * @param name      keresett rendező neve, részneve
     * @return          rendezők listája
     */
    private static java.util.List<catalogue.endpoint.DirectorItem> getDirectorsFilteredByNameService(java.lang.String name) {
        catalogue.endpoint.CatalogueService_Service service = new catalogue.endpoint.CatalogueService_Service();
        catalogue.endpoint.CatalogueService port = service.getCatalogueServicePort();
        return port.getDirectorsFilteredByNameService(name);
    }
    
    private static String deleteDirectorsService(java.util.List<java.lang.Integer> keys) {
        catalogue.endpoint.CatalogueService_Service service = new catalogue.endpoint.CatalogueService_Service();
        catalogue.endpoint.CatalogueService port = service.getCatalogueServicePort();
        return port.deleteDirectorsService(keys);
    }

    

    private static String insertGenreService(java.lang.String name) {
        catalogue.endpoint.CatalogueService_Service service = new catalogue.endpoint.CatalogueService_Service();
        catalogue.endpoint.CatalogueService port = service.getCatalogueServicePort();
        return port.insertGenreService(name);
    }

    private static java.util.List<catalogue.endpoint.GenreItem> getGenresService() {
        catalogue.endpoint.CatalogueService_Service service = new catalogue.endpoint.CatalogueService_Service();
        catalogue.endpoint.CatalogueService port = service.getCatalogueServicePort();
        return port.getGenresService();
    }

    

    private static String deleteGenreService(java.lang.Integer id) {
        catalogue.endpoint.CatalogueService_Service service = new catalogue.endpoint.CatalogueService_Service();
        catalogue.endpoint.CatalogueService port = service.getCatalogueServicePort();
        return port.deleteGenreService(id);
    }

    private static java.util.List<catalogue.endpoint.ReleaseItem> getReleasesService() {
        catalogue.endpoint.CatalogueService_Service service = new catalogue.endpoint.CatalogueService_Service();
        catalogue.endpoint.CatalogueService port = service.getCatalogueServicePort();
        return port.getReleasesService();
    }
    
    private static String insertReleaseService( java.lang.String name) {
        catalogue.endpoint.CatalogueService_Service service = new catalogue.endpoint.CatalogueService_Service();
        catalogue.endpoint.CatalogueService port = service.getCatalogueServicePort();
        return port.insertReleaseService(name);
    }

    private static String updateReleaseService(java.lang.Integer id, java.lang.String newName) {
        catalogue.endpoint.CatalogueService_Service service = new catalogue.endpoint.CatalogueService_Service();
        catalogue.endpoint.CatalogueService port = service.getCatalogueServicePort();
        return port.updateReleaseService(id, newName);
    }

    private static String deleteReleaseService(java.lang.Integer id) {
        catalogue.endpoint.CatalogueService_Service service = new catalogue.endpoint.CatalogueService_Service();
        catalogue.endpoint.CatalogueService port = service.getCatalogueServicePort();
        return port.deleteReleaseService(id);
    }

    private static MovieItem getMovieByKeyService(java.lang.Integer key) {
        catalogue.endpoint.CatalogueService_Service service = new catalogue.endpoint.CatalogueService_Service();
        catalogue.endpoint.CatalogueService port = service.getCatalogueServicePort();
        return port.getMovieByKeyService(key);
    }

    private static java.util.List<java.lang.Integer> getDirectorOfMovieService(int movieId) {
        catalogue.endpoint.CatalogueService_Service service = new catalogue.endpoint.CatalogueService_Service();
        catalogue.endpoint.CatalogueService port = service.getCatalogueServicePort();
        return port.getDirectorOfMovieService(movieId);
    }

    private static java.util.List<java.lang.Integer> getGenreOfMovieService(int movieId) {
        catalogue.endpoint.CatalogueService_Service service = new catalogue.endpoint.CatalogueService_Service();
        catalogue.endpoint.CatalogueService port = service.getCatalogueServicePort();
        return port.getGenreOfMovieService(movieId);
    }

    

    private static String updateGenreService(int id, java.lang.String newName) {
        catalogue.endpoint.CatalogueService_Service service = new catalogue.endpoint.CatalogueService_Service();
        catalogue.endpoint.CatalogueService port = service.getCatalogueServicePort();
        return port.updateGenreService(id, newName);
    }

    private static Integer getDirectorIdByNameService(java.lang.String name) {
        catalogue.endpoint.CatalogueService_Service service = new catalogue.endpoint.CatalogueService_Service();
        catalogue.endpoint.CatalogueService port = service.getCatalogueServicePort();
        return port.getDirectorIdByNameService(name);
    }

    private static Integer getGenreIdByNameService(java.lang.String name) {
        catalogue.endpoint.CatalogueService_Service service = new catalogue.endpoint.CatalogueService_Service();
        catalogue.endpoint.CatalogueService port = service.getCatalogueServicePort();
        return port.getGenreIdByNameService(name);
    }

    private static Integer getReleaseIdByNameService(java.lang.String name) {
        catalogue.endpoint.CatalogueService_Service service = new catalogue.endpoint.CatalogueService_Service();
        catalogue.endpoint.CatalogueService port = service.getCatalogueServicePort();
        return port.getReleaseIdByNameService(name);
    }

    private static String getDirectorNameByIdService(java.lang.Integer id) {
        catalogue.endpoint.CatalogueService_Service service = new catalogue.endpoint.CatalogueService_Service();
        catalogue.endpoint.CatalogueService port = service.getCatalogueServicePort();
        return port.getDirectorNameByIdService(id);
    }

    private static String getGenreNameByIdService(java.lang.Integer id) {
        catalogue.endpoint.CatalogueService_Service service = new catalogue.endpoint.CatalogueService_Service();
        catalogue.endpoint.CatalogueService port = service.getCatalogueServicePort();
        return port.getGenreNameByIdService(id);
    }

    private static String getReleaseNameByIdService(java.lang.Integer id) {
        catalogue.endpoint.CatalogueService_Service service = new catalogue.endpoint.CatalogueService_Service();
        catalogue.endpoint.CatalogueService port = service.getCatalogueServicePort();
        return port.getReleaseNameByIdService(id);
    }

    

    
    
}
