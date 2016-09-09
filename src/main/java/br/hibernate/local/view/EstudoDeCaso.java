package br.hibernate.local.view;


import br.hibernate.local.controller.CurriculoController;
import br.hibernate.local.model.Curriculo;
import br.hibernate.local.model.Descricao;
import br.hibernate.local.model.ObjetivoProfissional;
import br.hibernate.local.model.Pessoa;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class EstudoDeCaso extends JFrame implements WindowListener {

    private CurriculoController controller = new CurriculoController();

    private Pessoa pessoa = new Pessoa();
    private Descricao descricao = new Descricao();
    private ObjetivoProfissional objetivoProfissional = new ObjetivoProfissional();
    private Curriculo curriculo = new Curriculo();

    private CheckBoxMonitor obj = new CheckBoxMonitor();

    //Declaração das variáveis.
    private Font normalFont, negritoFont, italicoFont, negitaFont;
    private String plaf;
    private JPanel painelTop, painelMid, painelDown;
    private JButton salvar, procurar, alterar, deletar, sair;
    private JLabel nome, endereco, bairro,
            cidade, email,
            sexo, escolaridade,
            areasAtuacao, pretensaoSalarial,
            cargoDesejavel, estado;
    private JTextField nomeText, enderecoText,
            bairroText, cidadeText, emailText;
    private JTextArea areaTexto;
    private JRadioButton feminino, masculino;
    private ButtonGroup grupoSexo, grupoLAF, grupoTexto;
    private JComboBox comboEstados, comboEscolaridade,
            comboPretensaoSalarial, comboCargoDesejavel,
            comboAreasAtuacao;
    private Object itensEstadosCombo[] = {"AC", "AL",
            "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA",
            "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI",
            "RR", "RO", "RJ", "RN", "RS", "SC", "SP", "SE", "TO"};
    private Object itensPretensaoSalarial[] = {"500,00",
            "750,00", "1000,00", "1500,00", "2000,00", "2500,00",
            "3000,00", "3500,00", "4000,00", "4500,00", "5000,00",
            "Acima de 5000,00"};
    private Object itensEscolaridade[] = {"Fundamental Incompleto",
            "Fundamental", "Médio Incompleto", "Médio", "Técnico",
            "Superior Incompleto", "Superior", "Pós-Graduação",
            "Nenhum dos Acima"};
    private Object itensCargoDesejavel[] = {"Assistente",
            "Supervisor", "Gerente", "Diretor", "Analista",
            "Programador", "Redator", "Revisor", "Auxiliar",
            "Técnico", "Especialista", "Coordenador",
            "Chefe de Departamento"};
    private Object itensAreasAtuacao[] = {"Autônomo",
            "Agrárias", "Administrativas", "Artísticas",
            "Cálculo", "Ciências Biológicas", "Ciências Físicas",
            "Literárias", "Percursivas", "Sociais", "Outras"};
    private JMenuBar barraMenu;
    private JMenu arquivo, editar, sobre, texto, aparencia;
    private JMenuItem itemNovo, itemProcurar,
            itemSalvar, itemAlterar, itemDeletar,
            itemSair, itemSobre, itemHelp;
    private JRadioButtonMenuItem radioMotif, radioWindows, radioMetal;
    private JCheckBoxMenuItem checkNegrito,
            checkItalico, checkNormal, checkNegIta;
    private Border bordaPainelTop, bordaPainelMid, bordaPainelDown;

    public EstudoDeCaso() {
        // Criação dos Componentes
        painelTop = new JPanel();
        painelMid = new JPanel();
        painelDown = new JPanel();

        salvar = new JButton("Salvar");
        procurar = new JButton("Procurar");
        alterar = new JButton("Alterar");
        deletar = new JButton("Deletar");
        sair = new JButton("Sair");

        nome = new JLabel("Nome:");
        endereco = new JLabel("Endereço:");
        bairro = new JLabel("Bairro:");
        cidade = new JLabel("Cidade:");
        email = new JLabel("E-mail:");
        sexo = new JLabel("Sexo:");
        escolaridade = new JLabel("Escolaridade:");
        areasAtuacao = new JLabel("Áreas de Atuação:");
        pretensaoSalarial = new JLabel("Pretensão Salarial:");
        cargoDesejavel = new JLabel("Cargo Desejável:");
        estado = new JLabel("Estado:");

        nomeText = new JTextField();
        enderecoText = new JTextField();
        bairroText = new JTextField();
        cidadeText = new JTextField();
        emailText = new JTextField();

        areaTexto = new JTextArea(7, 62);
        JScrollPane barraRolagem = new JScrollPane(areaTexto);

        feminino = new JRadioButton("Feminino");
        masculino = new JRadioButton("Masculino");

        grupoSexo = new ButtonGroup();
        grupoLAF = new ButtonGroup();
        grupoTexto = new ButtonGroup();

        comboEstados = new JComboBox(itensEstadosCombo);
        comboAreasAtuacao = new JComboBox(itensAreasAtuacao);
        comboCargoDesejavel = new JComboBox(itensCargoDesejavel);
        comboEscolaridade = new JComboBox(itensEscolaridade);
        comboPretensaoSalarial = new JComboBox(itensPretensaoSalarial);

        barraMenu = new JMenuBar();
        arquivo = new JMenu("Arquivo");
        editar = new JMenu("Editar");
        sobre = new JMenu("Sobre");
        texto = new JMenu("Textos");
        aparencia = new JMenu("Aparência");

        itemNovo = new JMenuItem("Novo");
        itemSalvar = new JMenuItem("Salvar");
        itemProcurar = new JMenuItem("Procurar");
        itemDeletar = new JMenuItem("Deletar");
        itemAlterar = new JMenuItem("Alterar");
        itemSair = new JMenuItem("Sair");
        itemHelp = new JMenuItem("Help");
        itemSobre = new JMenuItem("Sobre");

        radioMetal = new JRadioButtonMenuItem("Metal (Padrão)");
        radioMotif = new JRadioButtonMenuItem("Motif");
        radioWindows = new JRadioButtonMenuItem("Windows");
        checkNormal = new JCheckBoxMenuItem("Normal");
        checkNegrito = new JCheckBoxMenuItem("Negrito");
        checkItalico = new JCheckBoxMenuItem("Itálico");
        checkNegIta = new JCheckBoxMenuItem("Negrito/Itálico");

        bordaPainelTop = BorderFactory.createTitledBorder(
                "Informações Pessoais");
        bordaPainelMid = BorderFactory.createTitledBorder(
                "Descrição Pessoal e Experiência Profissional");
        bordaPainelDown = BorderFactory.createTitledBorder(
                "Objetivo Profissional");

        // Definição do Layout do JFrame.
        setLayout(null);

        // Definição dos Paineis e as sua posições.
        painelTop.setLayout(null);
        painelTop.setBounds(10, 25, 705, 170);

        painelMid.setLayout(new java.awt.FlowLayout(0, 5, -3));
        painelMid.setBounds(10, 200, 705, 145);

        painelDown.setLayout(null);
        painelDown.setBounds(10, 345, 705, 140);

        // Associação dos ícones aos botões.
        salvar.setIcon(new ImageIcon("imagens/salvar.png"));
        /*
        salvar.setIcon(new ImageIcon(
                getClass().getResource(
                "../salvar.png")));
        procurar.setIcon(new ImageIcon(
                getClass().getResource(
                "imagens/procurar.png")));
        alterar.setIcon(new ImageIcon(
                getClass().getResource(
                "imagens/alterar.gif")));
        deletar.setIcon(new ImageIcon(
                getClass().getResource(
                "imagens/delete.png")));
        sair.setIcon(new ImageIcon(
                getClass().getResource(
                "imagens/sair.png")));
                 
        
        // Associação dos ícone e das teclas de atalho dos menus
        arquivo.setIcon(new ImageIcon(
                getClass().getResource(
                "imagens/folder.png")));
        editar.setIcon(new ImageIcon(
                getClass().getResource(
                "imagens/hammer_left.png")));
        sobre.setIcon(new ImageIcon(
                getClass().getResource(
                "imagens/about.png")));

        texto.setIcon(new ImageIcon(
                getClass().getResource(
                "imagens/texto.png")));
        texto.setToolTipText("Essas configurações só se aplicam"
                + " na área de DESCRIÇÃO PESSOAL");

        aparencia.setIcon(new ImageIcon(
                getClass().getResource(
                "imagens/aparencia.png")));

        itemNovo.setIcon(new ImageIcon(
                getClass().getResource(
                "imagens/new.png")));
        itemNovo.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_N, ActionEvent.CTRL_MASK));

        itemProcurar.setIcon(new ImageIcon(
                getClass().getResource(
                "imagens/find.png")));
        itemProcurar.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_P, ActionEvent.CTRL_MASK));

        itemSalvar.setIcon(new ImageIcon(
                getClass().getResource(
                "imagens/save.png")));
        itemSalvar.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_S, ActionEvent.CTRL_MASK));

        itemAlterar.setIcon(new ImageIcon(
                getClass().getResource(
                "imagens/alterar.gif")));
        itemAlterar.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_A, ActionEvent.CTRL_MASK));

        itemDeletar.setIcon(new ImageIcon(
                getClass().getResource(
                "imagens/delete.png")));
        itemDeletar.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_D, ActionEvent.CTRL_MASK));

        itemSair.setIcon(new ImageIcon(
                getClass().getResource(
                "imagens/sair.png")));
        itemSair.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_S, ActionEvent.CTRL_MASK));

        itemHelp.setIcon(new ImageIcon(
                getClass().getResource(
                "imagens/help.png")));
        itemHelp.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_F11, 0));

        itemSobre.setIcon(new ImageIcon(
                getClass().getResource(
                "imagens/sobre.png")));
        itemSobre.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_F12, 0));

        checkNormal.setIcon(new ImageIcon(
                getClass().getResource(
                "imagens/plain.png")));
        checkNormal.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_P, ActionEvent.ALT_MASK));

        checkNegrito.setIcon(new ImageIcon(
                getClass().getResource(
                "imagens/bold.png")));
        checkNegrito.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_N, ActionEvent.ALT_MASK));

        checkItalico.setIcon(new ImageIcon(
                getClass().getResource(
                "imagens/italic.png")));
        checkItalico.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_I, ActionEvent.ALT_MASK));

        checkNegIta.setIcon(new ImageIcon(
                getClass().getResource(
                "imagens/negita.png")));
        checkNegIta.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_A, ActionEvent.ALT_MASK));

        */
        // Definição dos Botões e de suas posições.
        salvar.setBounds(105, 490, 110, 25);
        procurar.setBounds(230, 490, 110, 25);
        alterar.setBounds(355, 490, 110, 25);
        deletar.setBounds(480, 490, 110, 25);
        sair.setBounds(605, 490, 110, 25);

        // Definição dos Rótulos e de suas posições.
        nome.setBounds(10, 10, 40, 25);
        endereco.setBounds(10, 60, 60, 25);
        bairro.setBounds(10, 110, 40, 25);
        cidade.setBounds(150, 110, 60, 25);
        estado.setBounds(310, 60, 60, 25);
        email.setBounds(310, 110, 50, 25);
        sexo.setBounds(430, 35, 40, 25);
        escolaridade.setBounds(40, 10, 80, 25);
        areasAtuacao.setBounds(40, 70, 110, 25);
        pretensaoSalarial.setBounds(450, 10, 130, 25);
        cargoDesejavel.setBounds(450, 70, 110, 25);

        // Definição dos JTextFields e de suas posições.
        nomeText.setBounds(10, 35, 280, 21);
        enderecoText.setBounds(10, 85, 280, 21);
        bairroText.setBounds(10, 135, 120, 21);
        cidadeText.setBounds(150, 135, 140, 21);
        emailText.setBounds(310, 135, 250, 21);

        // Definição dos JRadioButtons e de suas posições.
        feminino.setBounds(462, 58, 90, 25);
        masculino.setBounds(462, 35, 90, 25);

        // Definição dos JComboBox e de suas posições.
        comboEstados.setBounds(310, 85, 50, 21);
        comboEscolaridade.setBounds(40, 40, 180, 25);
        comboAreasAtuacao.setBounds(40, 100, 180, 25);
        comboPretensaoSalarial.setBounds(450, 40, 180, 25);
        comboCargoDesejavel.setBounds(450, 100, 180, 25);

        // Adição dos componentes JRadioButton ao ButtonGroup.
        grupoSexo.add(masculino);
        grupoSexo.add(feminino);

        grupoLAF.add(radioMetal);
        grupoLAF.add(radioMotif);
        grupoLAF.add(radioWindows);

        grupoTexto.add(checkNormal);
        grupoTexto.add(checkNegrito);
        grupoTexto.add(checkItalico);
        grupoTexto.add(checkNegIta);

        // Adição dos itens a barra de menu
        add(barraMenu).setBounds(0, 0, 740, 20);
        barraMenu.add(arquivo);
        barraMenu.add(editar);
        barraMenu.add(sobre);

        arquivo.add(itemNovo);
        arquivo.add(itemProcurar);
        arquivo.add(itemSalvar);
        arquivo.add(itemAlterar);
        arquivo.add(itemDeletar);
        arquivo.addSeparator();
        arquivo.add(itemSair);

        editar.add(texto);
        editar.add(aparencia);

        texto.add(checkNormal);
        texto.add(checkNegrito);
        texto.add(checkItalico);
        texto.add(checkNegIta);

        aparencia.add(radioMetal);
        aparencia.add(radioMotif);
        aparencia.add(radioWindows);

        sobre.add(itemHelp);
        sobre.add(itemSobre);

        // Definição das Bordas dos painéis
        painelTop.setBorder(bordaPainelTop);
        painelMid.setBorder(bordaPainelMid);
        painelDown.setBorder(bordaPainelDown);

        // Adiciona os componentes no JFrame.
        add(painelTop);
        add(painelMid);
        add(painelDown);

        add(salvar);
        add(procurar);
        add(alterar);
        add(deletar);
        add(sair);

        // Componentes adicionados no painelTop
        painelTop.add(nome);
        painelTop.add(endereco);
        painelTop.add(estado);
        painelTop.add(email);
        painelTop.add(cidade);
        painelTop.add(sexo);
        painelTop.add(bairro);

        painelTop.add(nomeText);
        painelTop.add(enderecoText);
        painelTop.add(bairroText);
        painelTop.add(cidadeText);
        painelTop.add(emailText);

        painelTop.add(masculino);
        painelTop.add(feminino);

        painelTop.add(comboEstados);

        // Componentes adicionados no painelMid
        painelMid.add(barraRolagem);

        // Componentes adicionados no painelDown
        painelDown.add(escolaridade);
        painelDown.add(areasAtuacao);
        painelDown.add(pretensaoSalarial);
        painelDown.add(cargoDesejavel);

        painelDown.add(comboEscolaridade);
        painelDown.add(comboAreasAtuacao);
        painelDown.add(comboPretensaoSalarial);
        painelDown.add(comboCargoDesejavel);

        // Definição das Fontes:
        normalFont = new Font("Verdana", Font.PLAIN, 12);
        negritoFont = new Font("Verdana", Font.BOLD, 12);
        italicoFont = new Font("Verdana", Font.ITALIC, 12);
        negitaFont = new Font("Verdana", Font.BOLD + Font.ITALIC, 12);

        // Área destinada a Manipulação dos Eventos
        salvar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {

                pessoa.setNome(nomeText.getText());
                pessoa.setEndereco(enderecoText.getText());
                pessoa.setBairro(bairroText.getText());
                pessoa.setCidade(cidadeText.getText());
                pessoa.setEmail(emailText.getText());
                pessoa.setEstado(comboEstados.getSelectedItem().toString());
                pessoa.setSexo(retornaSexo());

                controller.inserirPessoa(pessoa);

                descricao.setCodigoPessoa(controller.pesquisarCodigoPessoa(pessoa.getNome()));
                descricao.setDescricao(areaTexto.getText());

                controller.inserirDescricao(descricao);

                objetivoProfissional.setCodigoPessoa(descricao.getCodigoPessoa());
                objetivoProfissional.setEscolaridade(comboEscolaridade.getSelectedItem().toString());
                objetivoProfissional.setAreaAtuacao(comboAreasAtuacao.getSelectedItem().toString());
                objetivoProfissional.setCargoDesejavel(comboCargoDesejavel.getSelectedItem().toString());
                objetivoProfissional.setPretensaoSalarial(comboPretensaoSalarial.getSelectedItem().toString());

                controller.inserirObjProfissional(objetivoProfissional);

                limparTela();
            }
        });

        procurar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {

                if (nomeText.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Informe o nome para a consulta!");
                } else {
                    curriculo = controller.pesquisarCurriculoPorNome(nomeText.getText());
                    atualizarTela(curriculo);
                }
            }
        });

        alterar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {

                Integer codigoPessoa = curriculo.getCodigoPessoa();
                curriculo.setNome(nomeText.getText());
                curriculo.setEndereco(enderecoText.getText());
                curriculo.setBairro(bairroText.getText());
                curriculo.setCidade(cidadeText.getText());
                curriculo.setEmail(emailText.getText());
                curriculo.setEstado(comboEstados.getSelectedItem().toString());
                curriculo.setSexo(retornaSexo());
                curriculo.setDescricao(areaTexto.getText());
                curriculo.setCodigoPessoa(descricao.getCodigoPessoa());
                curriculo.setEscolaridade(comboEscolaridade.getSelectedItem().toString());
                curriculo.setAreaAtuacao(comboAreasAtuacao.getSelectedItem().toString());
                curriculo.setCargoDesejavel(comboCargoDesejavel.getSelectedItem().toString());
                curriculo.setPretensaoSalarial(comboPretensaoSalarial.getSelectedItem().toString());

                controller.alterarCurriculo(curriculo, codigoPessoa);
            }
        });

        deletar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {

                controller.excluiDados(curriculo.getCodigoPessoa());
                limparTela();
            }
        });

        sair.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                fechar();
            }
        });

        itemNovo.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                limparTela();
            }
        });

        itemSalvar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {

                pessoa.setNome(nomeText.getText());
                pessoa.setEndereco(enderecoText.getText());
                pessoa.setBairro(bairroText.getText());
                pessoa.setCidade(cidadeText.getText());
                pessoa.setEmail(emailText.getText());
                pessoa.setEstado(comboEstados.getSelectedItem().toString());
                pessoa.setSexo(retornaSexo());

                controller.inserirPessoa(pessoa);

                descricao.setCodigoPessoa(controller.pesquisarCodigoPessoa(pessoa.getNome()));
                descricao.setDescricao(areaTexto.getText());

                controller.inserirDescricao(descricao);

                objetivoProfissional.setCodigoPessoa(descricao.getCodigoPessoa());
                objetivoProfissional.setEscolaridade(comboEscolaridade.getSelectedItem().toString());
                objetivoProfissional.setAreaAtuacao(comboAreasAtuacao.getSelectedItem().toString());
                objetivoProfissional.setCargoDesejavel(comboCargoDesejavel.getSelectedItem().toString());
                objetivoProfissional.setPretensaoSalarial(comboPretensaoSalarial.getSelectedItem().toString());

                controller.inserirObjProfissional(objetivoProfissional);

                limparTela();
            }
        });

        itemProcurar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                if (nomeText.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Informe o nome para a consulta!");
                } else {
                    curriculo = controller.pesquisarCurriculoPorNome(nomeText.getText());
                    atualizarTela(curriculo);
                }
            }
        });

        itemAlterar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {

                Integer codigoPessoa = curriculo.getCodigoPessoa();

                curriculo.setNome(nomeText.getText());
                curriculo.setEndereco(enderecoText.getText());
                curriculo.setBairro(bairroText.getText());
                curriculo.setCidade(cidadeText.getText());
                curriculo.setEmail(emailText.getText());
                curriculo.setEstado(comboEstados.getSelectedItem().toString());
                curriculo.setSexo(retornaSexo());
                curriculo.setDescricao(areaTexto.getText());
                curriculo.setCodigoPessoa(descricao.getCodigoPessoa());
                curriculo.setEscolaridade(comboEscolaridade.getSelectedItem().toString());
                curriculo.setAreaAtuacao(comboAreasAtuacao.getSelectedItem().toString());
                curriculo.setCargoDesejavel(comboCargoDesejavel.getSelectedItem().toString());
                curriculo.setPretensaoSalarial(comboPretensaoSalarial.getSelectedItem().toString());

                controller.alterarCurriculo(curriculo, codigoPessoa);
            }
        });

        itemDeletar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                controller.excluiDados(curriculo.getCodigoPessoa());
                limparTela();
            }
        });

        itemSair.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                fechar();
            }
        });

        radioMetal.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                lookAndFeel();
            }
        });

        radioMotif.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                lookAndFeel();
            }
        });

        radioWindows.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                lookAndFeel();
            }
        });

        checkNormal.addItemListener(obj);
        checkNegrito.addItemListener(obj);
        checkItalico.addItemListener(obj);
        checkNegIta.addItemListener(obj);

        itemHelp.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                JOptionPane.showMessageDialog(null,
                        "Esta tela poderá ser implementada");
            }
        });

        itemSobre.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                JOptionPane.showMessageDialog(null,
                        "Esta tela poderá ser implementada");
            }
        });

        setTitle("Estudo de Caso");
        setSize(740, 560);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(this);
    }
    // Área destinada a Criação dos Métodos

    public void fechar() {
        if (JOptionPane.showConfirmDialog(null,
                "Deseja Fechar a Aplicação?",
                "ATENÇÃO ", JOptionPane.YES_NO_OPTION) == 0) {
            dispose();
        }
    }

    public String retornaSexo() {
        String sexoSelecionado = "";
        if (masculino.isSelected()) {
            sexoSelecionado = "Masculino";
        }
        if (feminino.isSelected()) {
            sexoSelecionado = "Feminino";
        }
        return sexoSelecionado;
    }


    public void atualizarTela(Curriculo curriculo) {

        if (curriculo.getSexo().equals("Masculino")) {
            masculino.setSelected(true);
        }
        if (curriculo.getSexo().equals("Feminino")) {
            feminino.setSelected(true);
        }

        nomeText.setText(curriculo.getNome());
        enderecoText.setText(curriculo.getEndereco());
        bairroText.setText(curriculo.getBairro());
        cidadeText.setText(curriculo.getCidade());
        emailText.setText(curriculo.getEmail());
        comboEstados.setSelectedItem(curriculo.getEstado());

        areaTexto.setText(curriculo.getDescricao());
        comboEscolaridade.setSelectedItem(
                curriculo.getEscolaridade());
        comboAreasAtuacao.setSelectedItem(
                curriculo.getAreaAtuacao());
        comboPretensaoSalarial.setSelectedItem(
                curriculo.getPretensaoSalarial());
        comboCargoDesejavel.setSelectedItem(
                curriculo.getCargoDesejavel());
    }

    public void limparTela() {
        nomeText.setText("");
        enderecoText.setText("");
        bairroText.setText("");
        cidadeText.setText("");
        emailText.setText("");
        comboEstados.setSelectedIndex(0);
        masculino.setSelected(false);
        feminino.setSelected(false);
        areaTexto.setText("");
        comboEscolaridade.setSelectedIndex(0);
        comboAreasAtuacao.setSelectedIndex(0);
        comboPretensaoSalarial.setSelectedIndex(0);
        comboCargoDesejavel.setSelectedIndex(0);
    }

    public void lookAndFeel() {
        if (radioWindows.isSelected()) {
            String plaf = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
            atualizaLAF(plaf);
        } else if (radioMotif.isSelected()) {
            String plaf = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
            atualizaLAF(plaf);
        } else {
            String plaf = "javax.swing.plaf.metal.MetalLookAndFeel";
            atualizaLAF(plaf);
        }
    }

    public void atualizaLAF(String plaf) {
        try {
            UIManager.setLookAndFeel(plaf);
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class CheckBoxMonitor implements ItemListener {

        public void itemStateChanged(ItemEvent evt) {
            JCheckBoxMenuItem ck = (JCheckBoxMenuItem) evt.getItemSelectable();
            if ((evt.getStateChange() == ItemEvent.SELECTED)
                    && (ck.getText().equals("Normal"))) {
                if (areaTexto.getSelectedText() != null) {
                    areaTexto.setFont(normalFont);
                }
            } else if ((evt.getStateChange() == ItemEvent.SELECTED)
                    && (ck.getText().equals("Negrito"))) {
                if (areaTexto.getSelectedText() != null) {
                    areaTexto.setFont(negritoFont);
                }
            } else if ((evt.getStateChange() == ItemEvent.SELECTED)
                    && (ck.getText().equals("Itálico"))) {
                if (areaTexto.getSelectedText() != null) {
                    areaTexto.setFont(italicoFont);
                }
            } else if ((evt.getStateChange() == ItemEvent.SELECTED)
                    && (ck.getText().equals("Negrito/Itálico"))) {
                if (areaTexto.getSelectedText() != null) {
                    areaTexto.setFont(negitaFont);
                }
            }
        }
    }

    public void windowActivated(WindowEvent e) {
    }

    public void windowClosed(WindowEvent e) {
    }

    public void windowClosing(WindowEvent e) {
        fechar();
    }

    public void windowDeactivated(WindowEvent e) {
    }

    public void windowDeiconified(WindowEvent e) {
    }

    public void windowIconified(WindowEvent e) {
    }

    public void windowOpened(WindowEvent e) {
    }

    public static void main(String args[]) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        String plaf = "javax.swing.plaf.metal.MetalLookAndFeel";
        try {
            UIManager.setLookAndFeel(plaf);
        } catch (Exception e) {
            e.printStackTrace();
        }
        EstudoDeCaso frame = new EstudoDeCaso();
    }
}
