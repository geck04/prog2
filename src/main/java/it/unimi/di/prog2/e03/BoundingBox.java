/*

Copyright 2024 Massimo Santini

This file is part of "Programmazione 2 @ UniMI" teaching material.

This is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This material is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this file.  If not, see <https://www.gnu.org/licenses/>.

*/

package it.unimi.di.prog2.e03;

import java.util.*;

/**
 * Vedi <a
 * href="https://github.com/mapio/labprog/blob/master/esercizi/bounding_box/Testo.md">testo</a>,
 */
public class BoundingBox {

  public BoundingBox() {}

  public static void main(String[] args) {
    ArrayList<String> elencoRighe = new ArrayList<String>();
    BoundingBox bb = new BoundingBox();
    try (Scanner s = new Scanner(System.in)) {
      while (s.hasNext()) {
        String linea = s.nextLine();
        elencoRighe.add(linea);
      }
      ArrayList<Integer> altezza_larghezza = new ArrayList<Integer>();
      altezza_larghezza = bb.getRettangolo(elencoRighe);
      System.out.println(altezza_larghezza.get(0) + " " + altezza_larghezza.get(1));
    } catch (Exception e) { // se si presenta un errore finisce qui
    }
  }

  private ArrayList<Integer> getRettangolo(ArrayList<String> elencoRighe) {
    int conrnerSinistro = 0;
    int cornerDestro = 0;
    int altezzaIniziale = 0;
    int altezzaFinale = 0;
    Boolean altezzaInizialeControllo = false;
    Boolean controlloSinistro = false;
    for (int i = 0; i < elencoRighe.size(); i++) {
      String riga = elencoRighe.get(i);
      if (riga.contains("*")) {

        if (altezzaInizialeControllo == false) {
          altezzaInizialeControllo = true;
          altezzaIniziale = i;
        }
        if (altezzaInizialeControllo == true) {
          altezzaFinale = i - altezzaIniziale + 1;
        }
        char[] caratteri = riga.toCharArray();
        for (int y = 0; y < caratteri.length; y++) {
          int pos = y;
          if (caratteri[y] == '*') {
            pos = y;
            if (pos > cornerDestro) {
              cornerDestro = pos;
            }
            if (controlloSinistro != true) {
              conrnerSinistro = pos;
              controlloSinistro = true;
            } else {
              if (pos < conrnerSinistro) {
                conrnerSinistro = pos;
              }
            }
          }
        }
      }
    }
    ArrayList<Integer> ritorno = new ArrayList<Integer>();
    // posizione 0 altezza
    // posizione 1 larghezza
    ritorno.add(altezzaFinale);
    ritorno.add((cornerDestro - conrnerSinistro + 1));

    return ritorno;
  }
}
