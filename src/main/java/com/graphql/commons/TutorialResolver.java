package com.graphql.commons;


import com.graphql.author.Author;
import com.graphql.author.AuthorRepository;
import com.graphql.tutorial.Tutorial;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TutorialResolver implements GraphQLResolver<Tutorial> {
  @Autowired
  private AuthorRepository authorRepository;
  public TutorialResolver(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }
  public Author getAuthor(Tutorial tutorial) {
    return authorRepository.findById(tutorial.getAuthor().getId()).orElseThrow(null);
  }
}