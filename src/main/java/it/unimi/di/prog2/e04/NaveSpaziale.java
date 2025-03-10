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

package it.unimi.di.prog2.e04;
public class NaveSpaziale {
  private int inizio, fine;
  private NaveSpaziale(int i, int f) {
    this.inizio=i;
    this.fine=f;
  }

  
  
  /** 
   * @return String
   */
  private String raggiungiPosizione(){
    String s="";
    while (this.inizio < this.fine) {
      if (this.fine % 2 == 1) {
          this.fine--;
          s+="P";
      } else if (this.fine >= 4 * this.inizio) {
          this.fine /= 4;
          s+="S";
      } else {
          this.fine--;
          s+="P";
      }
  }
      while (this.inizio > this.fine) {
          this.inizio--;
          s+="P";
      }
            return s;
  }



  public static void main(String[] args){
    int inizio = Integer.parseInt(args[0]);
    int fine = Integer.parseInt(args[1]);
    NaveSpaziale nave = new NaveSpaziale(inizio,fine);
    System.out.println(nave.raggiungiPosizione());
  }
  
}