package menu;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import sistema.SistemaAluno;



public class Menu {
	Scanner read =new Scanner(System.in);
		SistemaAluno sistema =new SistemaAluno();//instancia 
			int op;
			int id;
			 
 public void menuPrincipal() throws IOException {
	
			 do {
				 
				System.out.println("--------SISTEMA ESCOLAR--------");
				System.out.println("1- Área do Aluno");
				System.out.println("2- Área do Professor");
				System.out.println("3- Área da Coordenação ");
				System.out.println("0- SAIR");
				System.out.println("---------------------------------");
				
				System.out.println("Escolha uma opção : ");
	            op=read.nextInt();
				 
			 
			 switch(op) {
			 
			 case 1 :
				 menuAluno();
				 break;
			 case 2 :
				 menuProfessor();
				 break;
			 case 3:
				 menuCoordenacao();
				 break;
			 case 0:
				 System.out.println("Programa Encerrado ");
				 
			 }
		 }while(op!=0);
 }


public void menuCoordenacao() throws IOException {
	 
	 do {
	 System.out.println("-----------Área da Coordenação---------- ");		
	    System.out.println("1- Cadastrar Aluno ");
	    System.out.println("2- Alunos Cadastrados ");
	    System.out.println("3- Buscar Aluno  ");
	    System.out.println("4- Atualizar Aluno ");
	    System.out.println("5- Calcular Nota de Aluno ");
	    System.out.println("6- Resultado ");
	    System.out.println("7- Adicionar Nota Transferida ");
	    System.out.println("8- Notas dos Alunos ");
	    System.out.println("9- Deletar Aluno ");
	    System.out.println("0- Voltar  ");
	    System.out.println("--------------------------------------");
	    
     System.out.println("Escolha uma opção : ");
     op=read.nextInt();
     
	switch(op) {
	case 1 ://Cadastro 
		cadastroMenu();
		
		while(true) {
		System.out.println("Deseja cadastrar um novo aluno: ");
		System.out.println("1- Sim\n2- Não ");
		int escolha=read.nextInt();
		
		if(escolha==1) {
		 cadastroMenu();
		}
		else if(escolha==2) {
			break;
		}
		else {
			System.out.println("Opção Inválida ");
	  }
		
	}
       break;
	case 2: //Listar cadastro 
	      listarAlunos();
		
	break;
	case 3:  //bucar id
		buscarAlunosMenu();
	
		break;
	case 4: //editar
		
	   editarMenu();
		break;
		
	case 5 ://calcular Média
		calcularmMenu();
	break;
	case 6://situação dos alunos
	    sistema.resultadoAlunos();
		break;
		
	case 7://notas transferidas
		System.out.println("Digite o ID do Aluno para adicionar a nota: ");
		id=read.nextInt();
		sistema.adicionarNota(id);
		
		break;
	case 8:
		sistema.notasAlunos();
		break;
	
	case 9: //deletar
		System.out.println("Digite o ID que deseja remover : ");
		id=read.nextInt();
		boolean removido =sistema.deletarAluno(id);
		
		break;
	
	case 0 : menuPrincipal();
	      
	break;
	
	default: 
		System.out.println("Opção Inválida !");
	 }
}
	 while(op != 0);

}

public  void menuProfessor() throws IOException {
	     int opProf;
	     
	do {
	 System.out.println("--------Área do Professor --------- ");
	 
	 System.out.println("Escolha uma opção : ");
	 System.out.println("1- Alunos Cadastrados ");
	    System.out.println("2- Buscar Aluno  ");
	    System.out.println("3- Atualizar Aluno ");
	    System.out.println("4- Calcular Nota de Aluno ");
	    System.out.println("5- Resultado  ");
	    System.out.println("6- Notas");
	    System.out.println("7-Notas alunos Tranferidos ");
	    System.out.println("0- Voltar  ");
	    System.out.println("--------------------------------------");
		
		opProf=read.nextInt();
		
		switch(opProf) {
		
		case 1 : 
			listarAlunos();
		break;
		
		case 2:
		    buscarAlunosMenu();
		break;
		
		case 3: 
			editarMenu();
		break;
		
		case 4: System.out.println("------Calcular Notas---------");
		calcularmMenu();
		break;
		
		case 5: //resultado
		sistema.resultadoAlunos();
		
		break;
	
		case 6: 
		sistema.notasAlunos();	
		
		break;
		
		case 7: 
			System.out.println("------Adicionar notas( para alunos transferidos)---------");
		System.out.println("Digite o ID do Aluno para adicionar a nota: ");
		id=read.nextInt();
		sistema.adicionarNota(id);
		break;
		
		case 0:
			menuPrincipal();
        break;
        default:
        	System.out.println("Opção Inválida .");
		}	
	} while(opProf != 0);
	
}
 public  void menuAluno() throws IOException {
	 
	System.out.println("--------Área do Aluno--------- ");
	System.out.println("Digite seu IdAluno : " );
	id=read.nextInt();
	read.nextLine();
	int opAluno; 
	
	 String aluno= sistema.buscarID(id);
	  if (aluno==null) {
		  System.out.println(" Alunos não localizado . ");
		  return;
	  }
		
	do {
	System.out.println("--------------------------- ");
	System.out.println("Escolha uma opção : ");
	System.out.println("1- Notas ");
	System.out.println("2- Resultado ");
	System.out.println("0- Voltar ");
	
    opAluno= read.nextInt();
	
	switch(opAluno) {
	
	case 1:
		sistema.notas(id);
		break;
	case 2: System.out.println("------Resultado----");
	      sistema.listaresultado(id);
	break;
	case 0: 
		menuPrincipal();
		break;
		
   default: System.out.println("Opção inválida ");
	}	
	}
	while(opAluno != 0);
	}
 
 
 public void cadastroMenu() throws IOException {
	 
	 int op = -1; 
	 String sexo;
	 String nome;
	 int idade;
	 double grade, grade2, grade3,grade4;
	 
	 System.out.println("Digite o nome para Cadastro: ");
	    read.nextLine();
	    nome=read.nextLine();
	    while(nome.isEmpty()) {//não deixar cadastrar nome vazio
	    	System.out.println("Nome inválido\nDigite novamente um nome  :");
	    	nome=read.nextLine();
	    }

		System.out.println("Digite a idade do Aluno ");
		idade=read.nextInt();
		while (idade<=0) {//não permitir idade negativa
			System.out.println("Idade Inválida\nDigite novamante a idade : ");
			idade=read.nextInt();
		} 
		sexo=sistema.sexo();
		System.out.println("Digite a 1º nota do Aluno :");			
		grade=read.nextDouble();
		System.out.println("Digite a 2º nota do Aluno :");
		grade2=read.nextDouble();
		System.out.println("Digite a 3º nota do Aluno :");
		grade3=read.nextDouble();
		System.out.println("Digite a 4º nota do Aluno :");
		grade4=read.nextDouble();
	    int id = sistema.gerarId();
		sistema.cadastrarAluno(id, nome, idade, sexo, grade, grade2, grade3,grade4);//chamando metodo
     
 }

 public void listarAlunos() throws IOException {
	 ArrayList<String>lista= sistema.lerAlunos();//Foi criado instancio, pq metodo não era static
		if(lista.isEmpty()) {
			System.out.println("Não possui usuário cadastrado .");
		}else {
			System.out.println("----------Lista de Alunos Cadastrados----------");
			for(String linha:lista) { //a cada “passada” do for, a variável linha recebe o próximo elemento da lista, adicionando.
				
		    if (linha == null || linha.trim().isEmpty()) continue;
		    
			 String[]parte =linha.split("\\|");
			 int id=Integer.parseInt(parte[0]);
			 String nome=parte[1];
			 int idade=Integer.parseInt(parte[2]);
			 char sexo=parte[3].charAt(0);
			 
			 System.out.println("ID: "+parte[0]+"|"+"Nome: "+parte[1]+"|"+"Idade: "+parte[2]+"|"+"Sexo: "+parte[3]);
			}
		}
 }  
 
 public void buscarAlunosMenu() throws IOException {
		System.out.println("Digite o Id que deseja buscar : ");
		id=read.nextInt();
		read.nextLine();
		String busca=sistema.buscarID(id);
		
		if (busca ==null) {
			System.out.println("Não possui usuário cadastrado .");
		}else { 
			
			String[] parte = busca.split("\\|");

	    System.out.println(
	        "Id:" + parte[0] +
	        "| Aluno:" + parte[1] +
	        "| Idade:" + parte[2] +
	        "|Sexo:" + parte[3] +
	        "| Notas:" + parte[4] + "|" + parte[5] + "|" + parte[6] + "|" + parte[7]);
		}
 }
  public void editarMenu() throws IOException {
	  
	     String sexo;
		 String nome;
		 int idade;
		 double grade, grade2, grade3,grade4;
		 
	  System.out.println("Digite o Id que deseja atualizar : ");
		id=read.nextInt();
		read.nextLine();
		String usuario= sistema.buscarID(id);
		
		if(usuario ==null) {
			System.out.println("Usuario não localizado para atualizaçã, não é possivel atualizar . ");
			return;
		}
		
		System.out.println("Dados Atuais ");
		System.out.println(usuario);
		System.out.println("Digite o nome : ");
		nome=read.nextLine();
		System.out.println("Digite a idade : ");
		idade=read.nextInt();
		read.nextLine();
		sexo=sistema.sexo();
		System.out.println("Digite a 1º nota : ");
		grade=read.nextDouble();
		read.nextLine();
		System.out.println("Digite a 2º nota : ");
		grade2=read.nextDouble();
		read.nextLine();
		System.out.println("Digite a 3º nota : ");
		grade3=read.nextDouble();
		read.nextLine();
		System.out.println("Digite a 4º nota : ");
		grade4=read.nextDouble();
		read.nextLine();
		sistema.atualizarAluno(id, nome, idade,sexo,grade, grade2, grade3,grade4);
  }
  
 public void calcularmMenu() throws IOException {
		System.out.println("Digite o ID do aluno para calcular a nota : ");
		id=read.nextInt();
		String aluno= sistema.buscarID(id);
		if (aluno !=null) {
			double media = sistema.calculoNotas(aluno);
 }
 
 }

 }
 
 

			
			
		

	 

