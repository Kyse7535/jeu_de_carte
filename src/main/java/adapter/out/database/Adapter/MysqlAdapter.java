package adapter.out.database.Adapter;

import adapter.out.database.Entity.CompteEntity;
import adapter.out.database.Entity.HerosEntity;
import adapter.out.database.Mapper.CompteEntityMapper;
import adapter.out.database.Mapper.HerosEntityMapper;
import adapter.out.database.Repository.CompteRepository;
import adapter.out.database.Repository.HerosRepository;
import application.port.out.ComptePersistenceSpi;
import application.port.out.HerosPersistenceSpi;
import domain.Compte;
import domain.Heros;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MysqlAdapter implements ComptePersistenceSpi, HerosPersistenceSpi {

    private final CompteRepository compteRepository;
    private final HerosRepository herosRepository;

    public MysqlAdapter(CompteRepository compteRepository, HerosRepository herosRepository) {
        this.compteRepository = compteRepository;
        this.herosRepository = herosRepository;
    }


    @Override
    @Transactional
    public void save(Compte compte) {
        Optional<CompteEntity> optional = compteRepository.findById(compte.getPseudo());
        if(optional.isEmpty()) {
            CompteEntity entity = CompteEntityMapper.toEntity(compte);
            compteRepository.save(entity);
        }
    }

    @Override
    @Transactional
    public Compte load_compte(String pseudo) {
        return CompteEntityMapper.toDomain(compteRepository.findById(pseudo).get());
    }

    @Override
    public void update(Compte compte) {
        CompteEntity entity = CompteEntityMapper.toEntity(compte);
        compteRepository.save(entity);
    }

    @Override
    @Transactional
    public List<Compte> findAllPlayers() {

        List<CompteEntity> list= compteRepository.findAll();
        List<Compte> new_list = new ArrayList<>();
        for(CompteEntity compte : list) {
            new_list.add(CompteEntityMapper.toDomain(compte));
        }
        return new_list;
    }

    @Override
    public void save(Heros heros) {
        HerosEntity entity = HerosEntityMapper.toEntity(heros);
        herosRepository.save(entity);
    }

    @Override
    public Heros load_heros(String id) {
        return HerosEntityMapper.toDomain(herosRepository.findById(id).get());
    }

    @Override
    public void update(Heros heros) {
        HerosEntity entity = HerosEntityMapper.toEntity(heros);
        herosRepository.save(entity);
    }

    @Override
    public List<Heros> findAllHeros() {
        List<HerosEntity> list = herosRepository.findAll();
        List<Heros> new_list = new ArrayList<>();
        for(HerosEntity heros : list) {
            if(heros.enVie) {
                new_list.add(HerosEntityMapper.toDomain(heros));
            }
        }
        return new_list;
    }
}
