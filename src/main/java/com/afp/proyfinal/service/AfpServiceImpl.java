package com.afp.proyfinal.service;

import com.afp.proyfinal.dao.IAfpDao;
import com.afp.proyfinal.dao.IAssociationDao;
import com.afp.proyfinal.dao.IRemovalAfpDao;
import com.afp.proyfinal.dto.LinkClientResponse;
import com.afp.proyfinal.dto.RemovalAfpResponse;
import com.afp.proyfinal.entity.AFP;
import com.afp.proyfinal.entity.Association;
import com.afp.proyfinal.entity.RemovalAfp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AfpServiceImpl implements IAfpService{
    @Autowired
    private IAfpDao iAfpDao;

    @Autowired
    private IAssociationDao iAssociationDao;

    @Autowired
    private IRemovalAfpDao iRemovalAfpDao;

    @Override
    public LinkClientResponse linkClient(Association association) {
        //Optional<Association> op = iAssociationDao.findByIdClient(association.getClient());
        Boolean isPresent = iAssociationDao.existsByClient(association.getClient());
        if(isPresent){
            return new LinkClientResponse("client already has an afp");
        }else{
            Association associationResponse = iAssociationDao.save(association);
            return new LinkClientResponse("client successfully linked", associationResponse);
        }
        //return !op.isPresent() ?  iAssociationDao.save(association)  : op.get();
    }

    @Override
    public RemovalAfpResponse removalAfp(RemovalAfp removalAfp) {
        double afp =  removalAfp.getAssociation().getAvailableAmount();
        double retiro = removalAfp.getWithdrawalAmount();
        double descuen = afp * 0.5;
        System.out.println(afp);
        System.out.println(retiro);
        System.out.println(descuen);

        if(retiro>afp){
            return new RemovalAfpResponse("Unable to register the request. Amount greater than allowed "+descuen);
        }else if( retiro<descuen){
            return new RemovalAfpResponse("Minimum amount not covered please check the\n" +
                    "minimum withdrawal amount "+descuen);
        }else if(retiro>=descuen && retiro <=afp) {
          RemovalAfp removalAfpResponse= iRemovalAfpDao.save(removalAfp);
            return new RemovalAfpResponse("Request Accept "+retiro,removalAfpResponse);
        }else {
            return new RemovalAfpResponse("Required removal "+retiro);
        }
    }

    @Override
    public AFP createAfp(AFP afp) {
        return iAfpDao.save(afp);
    }

    @Override
    public List<AFP> findAllAfp() {
        return iAfpDao.findAll();
    }

    @Override
    public AFP findByIdAfp(Long id) {
        Optional<AFP> op =  iAfpDao.findById(id);
        return op.isPresent() ? op.get() : new AFP();
    }

    @Override
    public AFP updateAfp(AFP afp) {
        return iAfpDao.save(afp);
    }

    @Override
    public void deleteAfp(Long id) {
        iAfpDao.deleteById(id);
    }



}
