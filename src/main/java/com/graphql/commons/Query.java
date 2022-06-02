package com.graphql.commons;


import com.graphql.author.Author;
import com.graphql.author.AuthorRepository;
import com.graphql.tutorial.Tutorial;
import com.graphql.tutorial.TutorialRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {
    private final TutorialRepository tutorialRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public Query(TutorialRepository tutorialRepository, AuthorRepository authorRepository) {
        this.tutorialRepository = tutorialRepository;
        this.authorRepository = authorRepository;
    }
    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }
    public Iterable<Tutorial> findAllTutorials() {
        return tutorialRepository.findAll();
    }
    public long countAuthors() {
        return authorRepository.count();
    }
    public long countTutorials() {
        return tutorialRepository.count();
    }
}
