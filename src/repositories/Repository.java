package repositories;

import daos.DAOTextImpl;
import java.util.ArrayList;
import java.util.function.Predicate;
import model.Swipe;


public class Repository implements RepositoryInterface {
    private ArrayList<Swipe> items;    
    
    public Repository() {
        this.items = new ArrayList<>();       
    }
    
    public Repository(ArrayList<Swipe> items) {        
        this.items = items;
    }
    
    public Repository(String filename) {
        this();
        // Create dao and execute load
        DAOTextImpl dao = new DAOTextImpl();
        this.items = dao.load(filename).getItems();
    }
    
    @Override
    public ArrayList<Swipe> getItems() {        
        return this.items;
    }
    
    @Override
    public void setItems(ArrayList<Swipe> items) {        
        this.items = items;
    }
    
    @Override
    public void add(Swipe item) {
        this.items.add(item);
    }
     
    //lambda expressions 
    @Override
    public void remove(int id) {
        Predicate<Swipe> predicate = e->e.getId() == id;       
        this.items.removeIf(predicate);
        
        //what is predicate? is it possible to chane it 
    }
    
    @Override
    public Swipe getItem(int id) {
        for (Swipe item:this.items) {
            if (item.getId() == id)
                return item;
        }
        return null;
    }
    
    @Override
    public String toString() {
        return "\nItems: " + this.items;
    }    
    
    @Override
    public void store(String filename) {       
        // create dao and execute store    
        DAOTextImpl dao = new DAOTextImpl();
        dao.store(filename, this);
    }        
    
    public String toString(char delimiter)
    {
        String collectSwipes = "";
        for(Swipe swipe: this.items)
        {
            collectSwipes += swipe.toString(delimiter);
        }
        
    

