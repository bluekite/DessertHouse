package dao;

import model.Dessert;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Kite
 * Date: 13-3-8
 * Time: 下午9:07
 * To change this template use File | Settings | File Templates.
 */
public interface DessertDao {

    public void save(Dessert dessert);
    public ArrayList<Dessert> getAll();
    public Dessert find(String column,int value);
    public void sellByDesid(int id,int number,int sellnum);
    public void deleteByDesid(int id);
    public void updateByDesid(Dessert dessert);

}
