package com.everis.ejercicio1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.everis.ejercicio1.service.IParentsService;
import com.everis.ejercicio1.service.ParentsServiceImpl;

/**
 * 
 * @author kvilcave
 *
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class Ejercicio1ApplicationTests {

  @InjectMocks 
  private ParentsServiceImpl parentsServiceImpl;
  @Mock
  private IParentsService parService;
  
  
  @Test
  public void testParents_registrar() {
  //  when(parService.)
  }

}
