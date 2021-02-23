/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.Poterie;
import model.Utilisateur;

/**
 *
 * @author DELL
 */
public interface PoterieInterfaces {
    Poterie selectPoterie(int id);
    boolean updatePoterie(Poterie poterie);
    boolean updateVote(Poterie poterie);
    void insertPoterie(Poterie poterie);
  
    List<Poterie> selectPoterie();
    boolean deletePoterie(int id);
    
}
