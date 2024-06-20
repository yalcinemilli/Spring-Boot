package de.camovation.rauchboxapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import de.camovation.rauchboxapi.models.ObjektIdent;

public interface ObjektIdentRepository extends JpaRepository<ObjektIdent, Integer> {

    List<ObjektIdent> findByKundenid(int kundenid);
    ObjektIdent findById(int id);
    void deleteById(int id);
    void deleteByKundenid(int id);
    void deleteObjektIdentByKundenid(int id);

    
}
