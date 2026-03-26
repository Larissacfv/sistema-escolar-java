package aluno;

public class Aluno {
 private int ID;
private String nome;
 private int idade;
 private char sexo;
 
 public int getID() {
	return ID;
}
 public void setID(int iD) {
	ID = iD;
 }
 public String getNome() {
	return nome;
 }
 public void setNome(String nome) {
	this.nome = nome;
 }
 public int getIdade() {
	return idade;
 }
 public void setIdade(int idade) {
	this.idade = idade;
 }
 public char getSexo() {
	return sexo;
 }
 public void setSexo(char sexo) {
	this.sexo = sexo;
 }
 public double getGrade() {
	return grade;
 }
 public void setGrade(double grade) {
	this.grade = grade;
 }
 public double getGrade2() {
	return grade2;
 }
 public void setGrade2(double grade2) {
	this.grade2 = grade2;
 }
 public double getGrade3() {
	return grade3;
 }
 public void setGrade3(double grade3) {
	this.grade3 = grade3;
 }
 private double grade;
 private double grade2;
 private double grade3;
}
