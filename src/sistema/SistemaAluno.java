package sistema;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;



public class SistemaAluno {
	Scanner read  =new Scanner(System.in);
	
	public void cadastrarAluno(int id,String nome, int idade, String sexo, double grade, double grade2, double grade3, double grade4) throws IOException {
    //Esse método salva 
	  BufferedWriter bw= new BufferedWriter(new FileWriter("DadosdeAlunos.txt",true)); 
		bw.write(id+"|"+ nome+"|"+idade+"|"+sexo+"|"+grade+"|"+grade2+"|"+grade3+"|"+grade4);//escrever no arquivo
		bw.newLine();
		bw.close();
		
		System.out.println("---Dados do Aluno Cadastrado---");
		System.out.println("Id : "+id );
		System.out.println("Nome : "+nome );
		System.out.println("Idade : "+ idade);
		System.out.println("Sexo : "+sexo);
		System.out.println("1º Nota : "+grade );
		System.out.println("2º Nota : "+grade2 );
		System.out.println("3º Nota : "+grade3 );
		System.out.println("4º Nota : "+grade4 );
		System.out.println("--------------------------------------" );
		System.out.println("Cadastrado realizado com Sucesso ! ");
		System.out.println("--------------------------------------" );
	}
 
	     //Ele apenas lê o arquivo e coloca cada linha dentro do:
 public ArrayList<String> lerAlunos() throws IOException {//IOException trata erro do createNewFile 
	    ArrayList<String>alunos= new ArrayList<>();//guarda  dados que você não sabe a quantidade
	    
	    File arquivo= new File("DadosdeAlunos.txt");//File: representa arquivo ou pasta no computador, ele lê e salva varios dados
	    
	    if(!arquivo.exists()) {//verificando se o arquivo existe, se não existe 
	    	arquivo.createNewFile();//crie o arquivo
	    	}
	    
	    InputStream is= new FileInputStream("DadosdeAlunos.txt");//abre arquivo
	    InputStreamReader isr =new InputStreamReader(is);//converte bytes em texto 
	    BufferedReader br =new BufferedReader(isr);//lê linha por linha do texto convertido
	    
	    String linha;
	    while((linha= br.readLine())!=null) {//Enquanto o arquivo tiver linhas para ler, guarde na variável linha execute o código. Quando acabar, readLine() retorna null e o loop para.
	    	alunos.add(linha);
	    }
	     br.close();
	     isr.close();
	     is.close();//fechar antes do retorno.
	    
      return alunos;
 } 
      public int gerarId() throws IOException {
    	  
    	  File arquivo = new File("DadosdeAlunos.txt");

    	    if (!arquivo.exists()) {
    	        arquivo.createNewFile();
    	    }

    	    BufferedReader br = new BufferedReader(new FileReader(arquivo));// verifica se existe arquivo

    	  String linha;
    	  int ultimoId= 0;
    	  
    	  while((linha=br.readLine())!=null) {////Enquanto o arquivo tiver linhas para ler, guarde na variável linha execute o código. Quando acabar, readLine() retorna null e o loop para.
    		
    		  if (linha.trim().isEmpty()) {//se caso a linha estiver vazia.
    		 continue;
    	}
    		  
    		  String[] partes= linha.split("\\|");//[] array que separa a linha em parte, split usa "," para ser o separador
    		  int id= Integer.parseInt(partes[0]); //convertendo o indice 0 ID que era string vira int
    		  
    		  if (id>ultimoId) {//percorre ate chegar no ultimo ID
    			 ultimoId=id; 
    		  }
    	  }
    	  br.close();
		  return ultimoId+1;//ADD MAIS 1
    	    
      } 
      
      public String sexo() {
  		    
  		    while(true){  	
  		 System.out.println("Digite a opção do sexo: ");
  	     System.out.println("1- Feminino\n2-Masculino");
  		    int opSexo=read.nextInt();
  		    read.nextLine();
  		    
  		    if(opSexo==1) {
  		    	return "Feminino";
  		    }
  		    else if(opSexo==2) {
  		    	return "Masculino";
  		    }
  		    
  		    else {
  		    	System.out.println("Opção Inválida ");
  		   }
  		    
  		    }  
      }
      
     
      public String buscarID(int id) throws IOException {
		ArrayList<String>alunos=lerAlunos();
		for (String linha: alunos) { //percorrer 
			if (linha.startsWith(id+"|")){//pega o elemento que comece com
			   return linha;
			}
            
		}return null;
      }
      
      public void reescrevaAluno(ArrayList<String>alunos) throws IOException {
    	  //salva alterações.
    	  OutputStream os =new FileOutputStream("DadosdeAlunos.txt");
    	  OutputStreamWriter osw = new OutputStreamWriter(os);
    	  BufferedWriter bw= new BufferedWriter(osw);
    	  
    	  for(int i =0;i<alunos.size();i++) {
    		  
    		bw.write(alunos.get(i)); 
    		bw.newLine();
    		
    	  }
    	  
    	  bw.close();
    	  
      }

      public boolean atualizarAluno(int id, String nome, int idade, String sexo, double grade, double grade2, double grade3, double grade4) throws IOException{
    	  ArrayList<String>alunos=lerAlunos();
    	  boolean encontrado= false;
    	  
    	  for (int i =0;i<alunos.size();i++) {
         
    		  if (alunos.get(i).startsWith(id+"|")) {//pega o elemento que comece com
    			  
  			String atualizado= id+"|"+nome+"|"+idade+"|"+sexo+"|"+grade+"|"+grade2+"|"+grade3+"|"+grade4;
  			alunos.set(i, atualizado);//substitui 
  			
  			encontrado=true;//depois que foi encontrado é verdadeiro
  			break;
    		  }
    		  
  			}
  			if (encontrado) {
  				reescrevaAluno(alunos);
  				System.out.println("--------------------------------------" );
  			     System.out.println("Aluno atualizado com sucesso !");
  			    System.out.println("--------------------------------------" );
  			} else {
  				System.out.println("Aluno não encontrado ! ");
  			}
  			  return encontrado;
      }
      
      public void notas(int id) throws IOException {//alunos
    	
    	  String aluno= buscarID(id);
    	  
    	  if(aluno == null){
  		    System.out.println("Aluno não encontrado.");
  		    return;
    	  }
    	  String [] parte= aluno.split("\\|");
    	  
    	  String nome =parte[1];
    	  double grade =Double.parseDouble(parte[4]);
    	  double grade2 =Double.parseDouble(parte[5]);
    	  double grade3 =Double.parseDouble(parte[6]);
    	  double grade4 =Double.parseDouble(parte[7]);
    	  
    	  System.out.println("-----NOTAS------");
    	  System.out.println("Nome : "+nome );
    	  System.out.println("1º Nota: "+grade);
    	  System.out.println("2º Nota: "+grade2);
    	  System.out.println("3º Nota: "+grade3);
    	  System.out.println("4º Nota: "+grade4); 
    	  
      }
      public void notasAlunos() throws IOException {
    	  ArrayList<String>lista=lerAlunos();
    	  
    	  if(lista.isEmpty()) {
    		  System.out.println(" Alunos não localizado .");
    		  return;
    	  }
    	  System.out.println("-----NOTAS DOS ALUNOS------");
    	  for(String aluno:lista) {
    		  
    		  String []parte=aluno.split("\\|");
    		  
    		  String nome =parte[1];
        	  double grade =Double.parseDouble(parte[4]);
        	  double grade2 =Double.parseDouble(parte[5]);
        	  double grade3 =Double.parseDouble(parte[6]);
        	  double grade4 =Double.parseDouble(parte[7]);  
    		  
        	  System.out.println("Aluno : "+nome);
        	  System.out.println("Notas : "+parte[4]+"|"+parte[5]+"|"+parte[6]+"|"+parte[7]);
    	  }
    
      }
      public double calculoNotas( String aluno) {
    	  String[] parte =aluno.split("\\|");
    	  
    	  double grade =Double.parseDouble(parte[4]);
    	  double grade2 =Double.parseDouble(parte[5]);
    	  double grade3 =Double.parseDouble(parte[6]);
    	  double grade4 =Double.parseDouble(parte[7]);
    	  String nome =parte[1];
    	  
    	  double soma=grade+grade2+grade3+grade4;
    	  double media= soma/4;
    	  System.out.println("A soma das notas de "+nome+" é "+ soma);
    	  System.out.println("A média de "+nome+" é "+media);
    	  
    	  System.out.println("Deseja saber mais informações das notas do aluno : (S/N)");
          String resposta=read.nextLine();
        		
          if (resposta.equalsIgnoreCase("S")) {
          	
    	  double maior=grade;
    	  double menor=grade;
    	  
    	  if(grade2>maior) {
    		  maior=grade2;	  
    	  }
    	  if(grade3>maior) {
    		  maior=grade3;
    	  }
    	  if(grade4>maior) {
    		  maior=grade4;
    	  }
    	  if(grade2<menor) {
    		  menor=grade2;
    	  }
    	  if(grade3<menor) {
    		  menor=grade3;  
    	  }
    	  if (grade4<menor) {
    		  menor=grade4;
    	  }
    	  System.out.println("A maior nota de "+nome+" é : "+maior+" e a menor é :"+menor);
 }      
          
    	  return media;
      }
      public void listaresultado(int id) throws IOException  {//alunos
    	  ArrayList<String>alunos=lerAlunos();
    	  for(String lista:alunos) {
    		  
    		  if(lista.trim().isEmpty()) {
    			  continue;
    		  }
     	    String[] parte = lista.split("\\|");
    		  
    	  if(parte.length <8) {
    		  System.out.println("Notas incompletas ");
    		  continue;
    	  }
    	  
    	  int idAluno= Integer.parseInt(parte[0]);
    	  if (idAluno !=id) {
    		  continue;
    	  }
    	  
      double grade =Double.parseDouble(parte[4]);
 	  double grade2 =Double.parseDouble(parte[5]);
 	  double grade3 =Double.parseDouble(parte[6]);
 	  double grade4 =Double.parseDouble(parte[7]);
 	  
 	  double soma= grade+grade2+grade3+grade4;

 	 if(soma >= 60) {
 	    System.out.println("Resultado : APROVADO !");
 	}
 	else if(soma >= 40) {
 	    System.out.println("Resultado : RECUPERAÇÃO !");
 	}
 	else {
 	    System.out.println("Resultado : REPROVADO !");
 	}
 
	  }
  
      }
      public void resultadoAlunos() throws IOException { //professores e coodenador
    	  ArrayList<String>lista=lerAlunos();
    	  
    	  if(lista.isEmpty()) {
    		  System.out.println(" Alunos não localizado .");
    		  return;
    	  }
    	  
    	  System.out.println("-----RESULTADO FINAL DAS NOTAS------");
    	  for(String aluno:lista) {
    		  
    		  String []parte=aluno.split("\\|");
    		  
    		  String nome =parte[1];
        	  double grade =Double.parseDouble(parte[4]);
        	  double grade2 =Double.parseDouble(parte[5]);
        	  double grade3 =Double.parseDouble(parte[6]);
        	  double grade4 =Double.parseDouble(parte[7]);  
    		  
        	  double soma=(grade+grade2+grade3+grade4);
              String resul;
        	  if(soma>=60) {
             	   resul=" APROVADO !";
              } else if(soma>=40) {
                   resul=" RECUPERAÇÃO !";
            }else {
             	   resul=" REPROVADO !";
           }
        	  System.out.println("Aluno : "+nome);
        	  System.out.println("Nota : "+soma);
        	  System.out.println("Resultado : "+resul);
        	  System.out.println("-----------------------------------");
        	  
      }
      }
      
      public void adicionarNota(int id) throws IOException {
    	  ArrayList<String>alunos=lerAlunos();
    	  boolean encontrado=false;
    	  
    	  for (int i=0;i<alunos.size();i++) {
    		  String linha=alunos.get(i); //pega uma linha da lista alunos
    		  String[] parte= linha.split("\\|");//separa com virgulas
    		  int idBusca= Integer.parseInt(parte[0]);
    		  
    		  if (id==idBusca) {
    			  if(parte.length>=8) {//limite de notas somente 4
    				  System.out.println("O aluno já possui 4 notas.");
    				  return;
    			  }
    			  encontrado=true;
    			  
    			  System.out.println("Digite a nota: ");
    			 double grade4= read.nextDouble();
    			 linha= linha +"|"+grade4; //adiciona nova nota
    			 alunos.set(i, linha);//atualiza a linha na lista
    			 reescrevaAluno(alunos); 
    			 System.out.println("Nova nota adicionada com sucesso !");
    		  }
    		  
    	  }
    		 
    		if(!encontrado) {
    			System.out.println("Aluno não encontrado !");
    		}
    	  }
 	 
      public boolean deletarAluno(int id ) throws IOException {
    	  ArrayList<String>alunos=lerAlunos();//ler
    	  boolean removido=false;
    	  
    	  for(int i=0;i<alunos.size();i++) {
    		  if(alunos.get(i).startsWith(id+"|")){
    			  alunos.remove(i);
    			  removido=true;
    			  break;
    		  }
    	  }
    	  if (removido) {
    		  reescrevaAluno(alunos);
    		  System.out.println("Aluno removido com sucesso !");
    	  }else {
    		  System.out.println("Aluno não foi encontrado !");
    	  }
    	  return removido;
    	
      }

}

