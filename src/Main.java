import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main{

    //--Classes dos itens do exercício
    //Animais cadastrados-
    static class Animal{
        Tutor tutor;
        String nome;
        String especie;
        String raca;
        int idade;
        double peso;
        String historicoSaude;
    }

    static int animaisCadastrados = 0;

    //Tutor cadastrado-
    static class Tutor{
        String nome;
        String cpf;
        String telefone;
        String endereco;
        String email;
        String ativoInativo;
    }

   static int tutoresCadastrados = 0;

    //Medicamento cadastrado-
    static class Medicamento{
        String nome;
        String fabricante;
        String tipo;
        double valor;
        String validade;
        int quantidade;
    }

    //Veterinário cadastrado na clínica-
    static class Veterinario{
        String nome;
        int SRMV;
        String especialidade;
        int telefone;
        String email;
        double valorConsulta;
    }

    static class Consulta{
        Animal animal;
        String data;
        String hora;
        Veterinario veterinario;
        String sintoma;
        String diagnostico;
        Medicamento medicamento;
        double valor;
    }

    //Arraylists dos objetos do exercício--
    static ArrayList<Animal> animais = new ArrayList<>();
    static ArrayList<Tutor> tutores = new ArrayList<>();
    static ArrayList<Medicamento> medicamentos = new ArrayList<>();
    static ArrayList<Veterinario> veterinarios = new ArrayList<>();
    static ArrayList<Consulta> consultas = new ArrayList<>();

    //Tutores pré-cadastrados no programa--
    static void carregarTutoresTeste(){
        Tutor t1 = new Tutor();
        t1.nome = "João Silva";
        t1.cpf = "12345678901";
        t1.telefone = "11999999999";
        t1.endereco = "Rua A";
        t1.email = "joao@email.com";
        t1.ativoInativo = "Ativo";

        Tutor t2 = new Tutor();
        t2.nome = "Maria Souza";
        t2.cpf = "98765432100";
        t2.telefone = "11888888888";
        t2.endereco = "Rua B";
        t2.email = "maria@email.com";
        t2.ativoInativo = "Ativo";

        Tutor t3 = new Tutor();
        t3.nome = "Carlos Lima";
        t3.cpf = "11122233344";
        t3.telefone = "11777777777";
        t3.endereco = "Rua C";
        t3.email = "carlos@email.com";
        t3.ativoInativo = "Inativo";

        tutores.add(t1);
        tutores.add(t2);
        tutores.add(t3);
    }

    //Veterinários pré cadastrados na clínica;
    static void carregarVeterinariosTeste(){
        Veterinario v1 = new Veterinario();
        v1.nome = "Dr. Carlos Mendes";
        v1.SRMV = 12345;
        v1.especialidade = "Clínico Geral";
        v1.telefone = 1199991111;
        v1.email = "carlos@petcare.com";
        v1.valorConsulta = 120.00;

        Veterinario v2 = new Veterinario();
        v2.nome = "Dra. Fernanda Alves";
        v2.SRMV = 23456;
        v2.especialidade = "Dermatologia";
        v2.telefone = 1198882222;
        v2.email = "fernanda@petcare.com";
        v2.valorConsulta = 150.00;

        Veterinario v3 = new Veterinario();
        v3.nome = "Dr. Ricardo Lima";
        v3.SRMV = 34567;
        v3.especialidade = "Cirurgia";
        v3.telefone = 1197773333;
        v3.email = "ricardo@petcare.com";
        v3.valorConsulta = 300.00;

        Veterinario v4 = new Veterinario();
        v4.nome = "Dra. Juliana Rocha";
        v4.SRMV = 45678;
        v4.especialidade = "Cardiologia";
        v4.telefone = 1196664444;
        v4.email = "juliana@petcare.com";
        v4.valorConsulta = 200.00;

        veterinarios.add(v1);
        veterinarios.add(v2);
        veterinarios.add(v3);
        veterinarios.add(v4);
    }

    //Medicamentos pré cadastrados no estoque--
    static void carregarMedicamentosTeste(){
        Medicamento m1 = new Medicamento();
        m1.nome = "Paracetamol";
        m1.fabricante = "EMS";
        m1.tipo = "Analgésico";
        m1.valor = 15.50;
        m1.validade = "12/2026";
        m1.quantidade = 40;

        Medicamento m2 = new Medicamento();
        m2.nome = "Amoxicilina";
        m2.fabricante = "Medley";
        m2.tipo = "Antibiótico";
        m2.valor = 32.90;
        m2.validade = "08/2025";
        m2.quantidade = 115;

        Medicamento m3 = new Medicamento();
        m3.nome = "Vacina Antirrábica";
        m3.fabricante = "Zoetis";
        m3.tipo = "Vacina";
        m3.valor = 80.00;
        m3.validade = "05/2026";
        m3.quantidade = 200;

        Medicamento m4 = new Medicamento();
        m4.nome = "Vacina V8";
        m4.fabricante = "Vetnil";
        m4.tipo = "Vacina";
        m4.valor = 95.00;
        m4.validade = "09/2026";
        m4.quantidade = 102;

        Medicamento m5 = new Medicamento();
        m5.nome = "Atadura de Crepom";
        m5.fabricante = "Cremer";
        m5.tipo = "Atadura";
        m5.valor = 5.50;
        m5.validade = "Indeterminada";
        m5.quantidade = 54;

        Medicamento m6 = new Medicamento();
        m6.nome = "Bandagem Elástica";
        m6.fabricante = "Missner";
        m6.tipo = "Atadura";
        m6.valor = 12.00;
        m6.validade = "Indeterminada";
        m6.quantidade = 651;

        medicamentos.add(m1);
        medicamentos.add(m2);
        medicamentos.add(m3);
        medicamentos.add(m4);
        medicamentos.add(m5);
        medicamentos.add(m6);
    }

    //Pressione ENTER para continuar;
    static void enterCont(Scanner scanner){
        System.out.println("Pressione ENTER para continuar...");
        scanner.nextLine();
    }

    //Exibição de menu
    static void exibirMenu(){
        System.out.println("==========PET CARE==========");
        System.out.println("1. CADASTRAR TUTOR");
        System.out.println("2. CADASTRAR ANIMAL");
        System.out.println("3. CONSULTA VETERINÁRIA");
        System.out.println("4. CONSULTAS CADASTRADAS");
        System.out.println("5. ESTOQUE DE MEDICAMENTOS");
        System.out.println("6. INFORMAÇÕES DE CLIENTES CADASTRADOS");
        System.out.println("7. INFORMAÇÕES DE ANIMAIS CADASTRADOS");
        System.out.println("8. INFORMAÇÕES DE VETERINÁRIOS TRABALHANDO NA CLÍNICA");
        System.out.println("0. ENCERRAR PROGRAMA");
    }

    //Metodos relacionados ao menu do programa--
    //Cadastrar tutor;
    static void cadastrarTutor(Scanner scanner){
        Tutor t = new Tutor();

        System.out.println("==========CADASTRAR TUTOR==========");

        while(true){
            System.out.println("Informe o nome do Tutor: ");
            t.nome = scanner.nextLine();

            if (!t.nome.isEmpty()){
                break;
            }else{
                System.out.println("O nome do tutor não pode ficar em branco!!!");
            }
        }

        while(true){
            System.out.println("Informe o CPF do tutor: ");
            t.cpf = scanner.nextLine();

            if (t.cpf.matches("\\d{11}")){
                break;
            }else{
                System.out.println("O cpf do tutor deve conter 11 dígitos!");
            }
        }

        while(true){
            System.out.println("Informe o DDD e telefone do tutor: ");
            t.telefone = scanner.nextLine();

            if (t.telefone.matches("\\d{11}")){
                break;
            }else{
                System.out.println("Informe um telefone válido!!!");
            }
        }

        while(true){
            System.out.println("Informe o endereço do tutor: ");
            t.endereco = scanner.nextLine();
            if (!t.endereco.isEmpty()){
                break;
            }else{
                System.out.println("O endereço não pode ficar em branco!!!");
            }
        }

        while(true){
            System.out.println("Informe o email do tutor: ");
            t.email = scanner.nextLine();
            if (!t.email.isEmpty()){
                break;
            }else{
                System.out.println("O email não pode ficar em branco!!!");
            }
        }

        while(true){
            System.out.println("Ativo (s) | Inativo (n): ");
            String escolha = scanner.nextLine().toLowerCase();
            if (escolha.equals("s")){
                t.ativoInativo = "Ativo";
                System.out.println("O Tutor está ativo na clínica.");
                break;
            }
            else if(escolha.equals("n")){
                t.ativoInativo = "Inativo";
                System.out.println("O Tutor está inativo na clínica.");
                break;
            }else{
                System.out.println("Informe uma ação válida!");
            }
        }

        System.out.println("==========TUTOR CADASTRADO==========");
        System.out.println("NOME. " + t.nome);
        System.out.println("CPF. " + t.cpf);
        System.out.println("TELEFONE. " + t.telefone);
        System.out.println("ENDEREÇO. " + t.endereco);
        System.out.println("EMAIL. " + t.email);
        System.out.println("ATIVIDADE NA CLÍNICA. " + t.ativoInativo);

        System.out.println("=================================");

        System.out.println("Confirmar cadastro do tutor? (S/N): ");
        String cadastrar = scanner.nextLine();

        while(true){
            if(cadastrar.equals("s")){
                tutores.add(t);

                System.out.println("Tutor cadastrado com sucesso!!!");
                tutoresCadastrados++;

                return;

            }else if(cadastrar.equals("n")){
                System.out.println("Cadastro cancelado com sucesso!!!");
                return;
            }else{
                System.out.println("Informe uma ação válida!!!");
                cadastrar = scanner.nextLine().toLowerCase();
            }
        }
    }

    //Cadastrar animal;
    static void cadastrarAnimal(Scanner scanner){

        Animal a = new Animal();

        System.out.println("==========CADASTRAR PET==========");

        boolean tutorConfirmado = false;

        while(true){

            if(tutores.isEmpty()){
                System.out.println("Nenhum tutor cadastrado! Cadastre um tutor para ser responsável pelo pet!!!");
                enterCont(scanner);
                return;
            }else{
                informacoesClientes();

                System.out.println("Informe o tutor responsável pelo animal: ");
                int escolhaTutor = scanner.nextInt();
                scanner.nextLine();

                if(escolhaTutor > 0 && escolhaTutor <= tutores.size()){
                    a.tutor = tutores.get(escolhaTutor - 1);

                    if(a.tutor.ativoInativo.equals("Inativo")){
                        System.out.println("O Tutor não pode estar INATIVO na clínica!!!");
                        enterCont(scanner);
                        continue;
                    }

                    System.out.println("==========TUTOR CADASTRADO==========");
                    System.out.println("NOME. " + a.tutor.nome);
                    System.out.println("CPF. " + a.tutor.cpf);
                    System.out.println("TELEFONE. " + a.tutor.telefone);
                    System.out.println("ENDEREÇO. " + a.tutor.endereco);
                    System.out.println("EMAIL. " + a.tutor.email);
                    System.out.println("ATIVIDADE NA CLÍNICA. " + a.tutor.ativoInativo);

                    System.out.println("=================================");

                    while(true){
                        System.out.println("Confirmar Tutor selecionado? (S/N): ");
                        String escolha = scanner.nextLine().toLowerCase();

                        if(escolha.equals("s")){
                            System.out.println("Tutor selecionado com sucesso!!!");
                            enterCont(scanner);
                            tutorConfirmado = true;
                            break;
                        }else if(escolha.equals("n")){
                            a.tutor = null;
                            System.out.println("Escolha outro tutor!!!");
                            enterCont(scanner);
                        }else{
                            System.out.println("Informe uma ação válida!!!");
                            enterCont(scanner);
                        }
                    }

                    if(tutorConfirmado){
                        break;
                    }

                }else{
                    System.out.println("Opção inválida!");
                    enterCont(scanner);
                }
            }
        }

        while(true){
            System.out.println("Informe o nome do Pet: ");
            a.nome = scanner.nextLine();
            if (!a.nome.isEmpty()){
                break;
            }else{
                System.out.println("O nome do pet não pode ficar em branco!!!");
            }
        }

        while(true){
            System.out.println("Informe a espécie do Pet: ");
            a.especie = scanner.nextLine();
            if (!a.especie.isEmpty()){
                break;
            }else{
                System.out.println("Informe uma espécie para o pet!!!");
            }
        }

        while(true){
            System.out.println("Informe a raça do Pet: ");
            a.raca = scanner.nextLine();
            if (!a.raca.isEmpty()){
                break;
            }else{
                System.out.println("Informe uma raça para o pet!!!");
            }
        }

        while(true){
            System.out.println("Informe a idade do pet: ");
            a.idade = scanner.nextInt();
            scanner.nextLine();
            if (a.idade > 0){
                break;
            }else{
                System.out.println("A idade do pet não pode ser menor que 0!!!");
            }
        }

        while(true){
            System.out.println("Informe o peso do pet: ");
            a.peso = scanner.nextDouble();
            scanner.nextLine();
            if (a.peso > 0){
                break;
            }else{
                System.out.println("O peso do animal não pode ser menor que 0!!!");
            }
        }

        while(true){
            System.out.println("Informe o histórico de saúde do Pet: ");
            a.historicoSaude = scanner.nextLine();
            if (!a.historicoSaude.isEmpty()){
                break;
            }else{
                System.out.println("O pet precisa do histórico de saúde!!!");
            }
        }

        System.out.println("==========PET CADASTRADO==========");
        System.out.println("TUTOR RESPONSÁVEL. " + a.tutor.nome);
        System.out.println("NOME. " + a.nome);
        System.out.println("ESPÉCIE. " + a.especie);
        System.out.println("RAÇA. " + a.raca);
        System.out.println("IDADE. " + a.idade + " ANOS");
        System.out.println("PESO. " + a.peso + " KILOS");
        System.out.println("HISTÓRICO DE SAÚDE. " + a.historicoSaude);

        System.out.println("=================================");

        System.out.println("Confirmar cadastro do pet? (S/N): ");
        String cadastrar = scanner.nextLine();

        while(true){
            if(cadastrar.equals("s")){
                animais.add(a);

                System.out.println("Pet cadastrado com sucesso!!!");
                enterCont(scanner);
                return;

            }else if(cadastrar.equals("n")){
                System.out.println("Cadastro cancelado com sucesso!!!");
                return;

            }else{
                System.out.println("Informe uma ação válida!!!");
                cadastrar = scanner.nextLine().toLowerCase();
            }
        }
    }

    //Consulta veterinária;
    static void consultaVeterinaria(Scanner scanner){
        System.out.println("==========CONSULTA VETERINÁRIA==========");

        informacoesAnimais();
        if(animais.isEmpty()){
            return;
        }

        while(true){
            System.out.println("Informe o pet que precisa de uma consulta: ");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            if (escolha > 0 && escolha <= animais.size()){
                Animal a = animais.get(escolha -1);

                Consulta c = new Consulta();

                System.out.println("==========PET CADASTRADO==========");
                System.out.println("TUTOR RESPONSÁVEL. " + a.tutor.nome);
                System.out.println("NOME. " + a.nome);
                System.out.println("ESPÉCIE. " + a.especie);
                System.out.println("RAÇA. " + a.raca);
                System.out.println("IDADE. " + a.idade + " ANOS");
                System.out.println("PESO. " + a.peso + " KILOS");
                System.out.println("HISTÓRICO DE SAÚDE. " + a.historicoSaude);

                while(true){
                    System.out.println("Confirmar animal? (S/N): ");
                    String acao = scanner.nextLine().toLowerCase();

                    if(acao.equals("s")){
                        c.animal = a;
                        break;

                    }else if(acao.equals("n")){
                        System.out.println("Ação cancelada com sucesso!");
                        return;

                    }else{
                        System.out.println("Informe uma ação válida!!!");
                    }
                }

                System.out.println("Informe a data da consulta (EX: 20/06/2026): ");
                c.data = scanner.nextLine();

                System.out.println("Informe a hora da consulta (EX: 20:50): ");
                c.hora = scanner.nextLine();

                informacoesVeterinarios();
                while(true){
                    System.out.println("Informe o Veterinário que vai realizar o atendimento: ");
                    int escolhaVet = scanner.nextInt();
                    scanner.nextLine();

                    if (escolhaVet > 0 && escolhaVet <= veterinarios.size()){
                        Veterinario v = veterinarios.get(escolhaVet - 1);

                        System.out.println("==========VETERINÁRIO SELECIONADO==========");
                        System.out.println("VETERINÁRIO. " + v.nome);
                        System.out.println("SRMV. " + v.SRMV);
                        System.out.println("ESPECIALIDADE. " + v.especialidade);
                        System.out.println("TELEFONE. " + v.telefone);
                        System.out.println("EMAIL. " + v.email);
                        System.out.println("VALOR DA CONSULTA. " + v.valorConsulta);

                        c.veterinario = v;
                        enterCont(scanner);
                        break;

                    }else{
                        System.out.println("Veterinário não encontrado!!!");
                        enterCont(scanner);
                        return;
                    }
                }

                System.out.println("Informe os sintomas apresentados pelo pet: ");
                c.sintoma = scanner.nextLine();

                System.out.println("Informe o diagnóstico do veterinário: ");
                c.diagnostico = scanner.nextLine();

                estoqueMedicamentos();

                while(true){
                    System.out.println("Informe o medicamento a ser utilizado: ");
                    int escolhaMed = scanner.nextInt();
                    scanner.nextLine();

                    if (escolhaMed > 0 && escolhaMed <= medicamentos.size()){
                        Medicamento m = medicamentos.get(escolhaMed - 1);

                        System.out.println("==========MEDICAMENTO==========");
                        System.out.println("NOME. " + m.nome);
                        System.out.println("FABRICANTE. " + m.fabricante);
                        System.out.println("TIPO. " + m.tipo);
                        System.out.println("VALOR. R$" + m.valor);
                        System.out.println("VALIDADE. " + m.validade);
                        System.out.println("QUANTIDADE EM ESTOQUE. " + m.quantidade);

                        enterCont(scanner);
                        c.medicamento = m;
                        m.quantidade = m.quantidade -1;
                        break;
                    }
                    else{
                        System.out.println("Medicamento não presente no estoque!!!");
                        enterCont(scanner);
                        return;
                    }
                }

                System.out.println("==========CONSULTA VETERINÁRIA==========");
                System.out.println("RESPONSÁVEL PELO PET. " + a.tutor.nome);
                System.out.println("PET. " + c.animal.nome);
                System.out.println("DATA. " + c.data);
                System.out.println("HORA. " + c.hora);
                System.out.println("VETERINÁRIO. " + c.veterinario.nome);
                System.out.println("SINTOMA. " + c.sintoma);
                System.out.println("DIAGNOSTICO. " + c.diagnostico);
                System.out.println("MEDICAMENTO. " + c.medicamento.nome);
                System.out.println("VALOR DA CONSULTA. R$" + (c.veterinario.valorConsulta + c.medicamento.valor));
                System.out.println("========================================");

                consultas.add(c);
                System.out.println("Consulta cadastrada com sucesso!!!");
                enterCont(scanner);
                break;

            }else{
                System.out.println("Informe um pet cadastrado na clínica!!!");
                enterCont(scanner);
            }
        }
    }

    //Informações de consultas cadastradas;
    static void consultasCadastradas(){
        System.out.println("==========CONSULTAS VETERINÁRIAS==========");

        if(consultas.isEmpty()){
            System.out.println("Nenhuma consulta cadastrada!!!");
        }
        else{
            for(int i = 0; i < consultas.size(); i++){
                Consulta c = consultas.get(i);

                System.out.println(i + 1 + ". | RESPONSÁVEL. " + c.animal.tutor.nome +
                        " | PET. " + c.animal.nome +
                        " | DATA. " + c.data +
                        " | HORA. " + c.hora +
                        " | VETERINÁRIO. " + c.veterinario.nome +
                        " | SINTOMA. " + c.sintoma +
                        " | DIAGNOSTICO. " + c.diagnostico +
                        " | MEDICAMENTO. " + c.medicamento.nome +
                        " | VALOR. R$ " + (c.veterinario.valorConsulta + c.medicamento.valor));

                System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
            }
        }
    }

    //Informações de medicamentos em estoque;
    static void estoqueMedicamentos(){
        System.out.println("==========ESTOQUE DE MEDICAMENTOS==========");

        if(medicamentos.isEmpty()){
            System.out.println("Nenhum medicamento cadastrado!!!");
        }
        else{
            for(int i = 0; i < medicamentos.size(); i++){
                Medicamento m = medicamentos.get(i);

                System.out.println(i + 1 + ". | NOME. " + m.nome +
                        " | FABRICANTE. " + m.fabricante +
                        " | TIPO. " + m.tipo +
                        " | VALOR. R$ " + m.valor +
                        " | VALIDADE. " + m.validade +
                        " | QUANTIDADE EM ESTOQUE. " + m.quantidade);

                System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
            }
        }
    }

    //Informações de clientes da clínica;
    static void informacoesClientes(){
        System.out.println("==========INFORMAÇÕES DE TUTORES==========");

        if(tutores.isEmpty()){
            System.out.println("Nenhum tutor cadastrado!!!");
        }
        else{
            for(int i = 0; i < tutores.size(); i++){
                Tutor t = tutores.get(i);

                System.out.println(i + 1 + ". | NOME. " + t.nome +
                        " | CPF. " + t.cpf +
                        " | TELEFONE. " + t.telefone +
                        " | ENDEREÇO. " + t.endereco +
                        " | ATIVIDADE CLÍNICA. " + t.ativoInativo);

                System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
            }
        }
    }

    //Informações de animais cadastrados;
    static void informacoesAnimais() {
        System.out.println("==========INFORMAÇÕES DE PETS==========");

        if (animais.isEmpty()) {
            System.out.println("Nenhum animal cadastrado!!!");
        } else {
            for (int i = 0; i < animais.size(); i++) {
                Animal a = animais.get(i);

                System.out.println(i + 1 + ". | NOME. " + a.nome +
                        " | ESPÉCIE. " + a.especie +
                        " | RAÇA. " + a.raca +
                        " | IDADE. " + a.idade +
                        " | PESO. " + a.peso +
                        " | HISTÓRICO DE SAÚDE. " + a.historicoSaude +
                        " | TUTOR. " + a.tutor.nome);

                System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
            }
        }
    }

    //Informações de Veterinários cadastrados;
    static void informacoesVeterinarios(){
        System.out.println("==========INFORMAÇÕES DE VETERINÁRIOS==========");

        if (veterinarios.isEmpty()) {
            System.out.println("Nenhum veterinário cadastrado!!!");
        } else {
            for (int i = 0; i < veterinarios.size(); i++) {
                Veterinario v = veterinarios.get(i);

                System.out.println(i + 1 + ". | NOME. " + v.nome +
                        " | SRMV. " + v.SRMV +
                        " | ESPECIALIDADE. " + v.especialidade +
                        " | TELEFONE. " + v.telefone +
                        " | EMAIL. " + v.email +
                        " | VALOR CONSULTA. R$ " + v.valorConsulta);

                System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
            }
        }
    }

    //Execução do programa;
    public static void main(String[] args) {

        carregarVeterinariosTeste();
        carregarMedicamentosTeste();
        carregarTutoresTeste();

        Scanner scanner = new Scanner(System.in);


        while(true){
            exibirMenu();

            System.out.println("Informe a ação a ser tomada: ");

            int acao = scanner.nextInt();
            scanner.nextLine();

            switch (acao){
                case 1:
                    cadastrarTutor(scanner);
                    break;

                case 2:
                    cadastrarAnimal(scanner);
                    break;

                case 3:
                    consultaVeterinaria(scanner);
                    enterCont(scanner);
                    break;

                case 4:
                    consultasCadastradas();
                    enterCont(scanner);
                    break;

                case 5:
                    estoqueMedicamentos();
                    enterCont(scanner);
                    break;

                case 6:
                    informacoesClientes();
                    enterCont(scanner);
                    break;

                case 7:
                    informacoesAnimais();
                    enterCont(scanner);
                    break;

                case 8:
                    informacoesVeterinarios();
                    enterCont(scanner);
                    break;

                case 0:
                    System.out.println("Encerrando programa...");
                    enterCont(scanner);
                    return;
            }
        }
    }
}