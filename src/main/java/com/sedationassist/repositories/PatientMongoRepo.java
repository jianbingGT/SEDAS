//package com.sedationassist.repositories;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.bson.types.ObjectId;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Example;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//
//import com.sedationassist.model.PatientMongo;
//
//public class PatientMongoRepo implements PatientMongoRepository {
//	@Autowired
//	private PatientMongoRepository patientrepository;
//	@Override
//	public PatientMongo findOneByName(String name) {
//
//		return patientrepository.findOneByName(name);
//	}

//	@Override
//	public <S extends PatientMongo> List<S> findAll(Example<S> arg0) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public <S extends PatientMongo> List<S> findAll(Example<S> arg0, Sort arg1) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public <S extends PatientMongo> S insert(S arg0) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public <S extends PatientMongo> List<S> insert(Iterable<S> arg0) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public <S extends PatientMongo> List<S> save(Iterable<S> arg0) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Page<PatientMongo> findAll(Pageable arg0) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public long count() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public void delete(PatientMongo arg0) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void deleteAll() {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void deleteAll(Iterable<? extends PatientMongo> arg0) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void deleteById(String arg0) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public boolean existsById(String arg0) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public Iterable<PatientMongo> findAllById(Iterable<String> arg0) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Optional<PatientMongo> findById(String arg0) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public <S extends PatientMongo> S save(S arg0) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public <S extends PatientMongo> Iterable<S> saveAll(Iterable<S> arg0) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public <S extends PatientMongo> long count(Example<S> arg0) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public <S extends PatientMongo> boolean exists(Example<S> arg0) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public <S extends PatientMongo> Page<S> findAll(Example<S> arg0, Pageable arg1) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public <S extends PatientMongo> Optional<S> findOne(Example<S> arg0) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public PatientMongo findByid(ObjectId id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public PatientMongo findOneByName(String name) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<PatientMongo> findAll() {
//		// TODO Auto-generated method stub
//		return null;
//	}

//}
