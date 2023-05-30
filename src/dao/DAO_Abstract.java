/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.awt.List;

/**
 *
 * @author u03402615100
 */
public abstract class DAO_Abstract {
    public abstract  void insert(Object object);
    public abstract  void update(Object object);
    public abstract  void delete(Object object);
    public abstract  Object list(int id);
    public abstract  List listAll();
}

