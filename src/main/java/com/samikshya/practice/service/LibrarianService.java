package com.samikshya.practice.service;

import com.samikshya.practice.domain.Librarian;
import com.samikshya.practice.repository.LibrarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class LibrarianService {

    @Autowired
    private LibrarianRepository librarianRepository;

    public Librarian addLibrarian(Librarian librarian){
        return librarianRepository.save(librarian);
    }

    public Librarian getLibrarianById(Long id){
        return librarianRepository.findById(id).get();
    }

    public List<Librarian> getAllLibrarian(){
        return librarianRepository.findAll();
    }

    public Librarian deleteLibrarian(Long id) throws Exception {
        Librarian librarian = getLibrarianById(id);
        if(librarian == null){
            throw new Exception("Librarian no found");
        }
        librarianRepository.delete(librarian);
        return librarian;

    }

    public Librarian updateLibrarian(Long id, Librarian librarian) throws  Exception{
        Librarian librarian1 = getLibrarianById(id);
        if(librarian1 == null){
            throw  new Exception("Librarian not found");
        }

        if(librarian.getDateOfBirth() != null){
            librarian1.setDateOfBirth(librarian.getDateOfBirth());
        }
        if(librarian.getEmploymentDate() != null){
            librarian1.setEmploymentDate(librarian.getEmploymentDate());
        }

        if(librarian.getEmail() != null){
            librarian1.setEmail(librarian.getEmail());
        }

        if(librarian.getName() != null){
            librarian1.setName(librarian.getName());
        }

        if(librarian.getPassword() != null){
            librarian1.setPassword(librarian.getPassword());
        }
        return librarianRepository.save(librarian1);
    }
}
