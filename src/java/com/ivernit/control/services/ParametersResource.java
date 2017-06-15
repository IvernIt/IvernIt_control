/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.control.services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author sampru
 */
@Path("parameters")
public class ParametersResource {

  @Context
  private UriInfo context;

  /**
   * Creates a new instance of ParametersResource
   */
  public ParametersResource() {
  }

  /**
   * GET method for adding a new order
   *
   * @return
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public String getAll() {
    String tot = "";
    try {
      File file = new File("parameters.json");
      if (!file.exists()) {
        createFile(file);
      }
      String line;
      ArrayList<String> lines = new ArrayList();
      try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
        line = br.readLine();
        while (line != null) {
          lines.add(line);
          line = br.readLine();
        }
      }
      try (FileWriter fw = new FileWriter(file); BufferedWriter bw = new BufferedWriter(fw)) {
        for (String l : lines) {
          tot += l + "\n";
        }
        bw.write(tot);
        System.out.println(tot);
      }
    } catch (FileNotFoundException ex) {
      Logger.getLogger(ParametersResource.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(ParametersResource.class.getName()).log(Level.SEVERE, null, ex);
    }
    return tot;
  }

  /**
   * GET method for adding a new order
   *
   * @param num representation for the resource
   * @return
   */
  @GET
  @Path("agua/{num}")
  @Consumes(MediaType.APPLICATION_XML)
  @Produces(MediaType.APPLICATION_JSON)
  public String putAgua(@PathParam("num") String num) {
    String tot = "";
    try {
      ArrayList<String> lines = new ArrayList();
      String line;
      File file = new File("parameters.json");
      if (!file.exists()) {
        createFile(file);
      }
      System.out.println(file.getAbsolutePath());
      try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
        line = br.readLine();
        while (line != null) {
          if (line.contains("agua")) {
            line = "  \"agua\": \"" + num + "\",";
          }
          lines.add(line);
          line = br.readLine();
        }
      }
      try (FileWriter fw = new FileWriter(file); BufferedWriter bw = new BufferedWriter(fw)) {
        for (String l : lines) {
          tot += l + "\n";
        }
        bw.write(tot);
        System.out.println(tot);
      }
    } catch (FileNotFoundException ex) {
      Logger.getLogger(ParametersResource.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(ParametersResource.class.getName()).log(Level.SEVERE, null, ex);
    }
    return tot;
  }

  /**
   * GET method for adding a new order
   *
   * @param num representation for the resource
   * @return
   */
  @GET
  @Path("temperatura/{num}")
  @Consumes(MediaType.APPLICATION_XML)
  @Produces(MediaType.APPLICATION_JSON)
  public String putTemperatura(@PathParam("num") String num
  ) {
    String tot = "";
    try {
      ArrayList<String> lines = new ArrayList();
      String line;
      File file = new File("parameters.json");
      if (!file.exists()) {
        createFile(file);
      }
      try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
        line = br.readLine();
        while (line != null) {
          if (line.contains("temperatura")) {
            line = "  \"temperatura\": \"" + num + "\",";
          }
          lines.add(line);
          line = br.readLine();
        }
      }
      try (FileWriter fw = new FileWriter(file); BufferedWriter bw = new BufferedWriter(fw)) {
        for (String l : lines) {
          tot += l + "\n";
        }
        bw.write(tot);
        System.out.println(tot);
      }
    } catch (FileNotFoundException ex) {
      Logger.getLogger(ParametersResource.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(ParametersResource.class.getName()).log(Level.SEVERE, null, ex);
    }
    return tot;
  }

  /**
   * GET method for adding a new order
   *
   * @param num representation for the resource
   * @return
   */
  @GET
  @Path("luz/{num}")
  @Consumes(MediaType.APPLICATION_XML)
  @Produces(MediaType.APPLICATION_JSON)
  public String putLuz(@PathParam("num") String num
  ) {
    String tot = "";
    try {
      ArrayList<String> lines = new ArrayList();
      String line;
      File file = new File("parameters.json");
      if (!file.exists()) {
        createFile(file);
      }
      try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
        line = br.readLine();
        while (line != null) {
          if (line.contains("luz")) {
            line = "  \"luz\": \"" + num + "\",";
          }
          lines.add(line);
          line = br.readLine();
        }
      }
      try (FileWriter fw = new FileWriter(file); BufferedWriter bw = new BufferedWriter(fw)) {
        for (String l : lines) {
          tot += l + "\n";
        }
        bw.write(tot);
        System.out.println(tot);
      }
    } catch (FileNotFoundException ex) {
      Logger.getLogger(ParametersResource.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(ParametersResource.class.getName()).log(Level.SEVERE, null, ex);
    }
    return tot;
  }

  private void createFile(File file) throws IOException {
    file.createNewFile();
    try (FileWriter fw = new FileWriter(file); BufferedWriter bw = new BufferedWriter(fw)) {
      bw.write("{\n"
              + "  \"agua\": \"0\",\n"
              + "  \"luz\": \"0\",\n"
              + "  \"temperatura\": \"0\",\n"
              + "  \"chk\" : \"OK\"\n"
              + "}");
    }
  }
}
