package com.project.konsumenview.models;

import java.util.Date;

import lombok.Data;

@Data
public class Konsumen {

  private Integer idKonsumen;
  private String nama;
  private String alamat;
  private String kota;
  private String provinsi;
  private Date tglRegistrasi;
  private String status;
}
