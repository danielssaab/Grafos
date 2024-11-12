// Caminho: src/MainFrame.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
	private Grafo grafo;

	public MainFrame() {
		setTitle("Gerenciador de Grafos");
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		// Painel superior para escolha do tipo de grafo
		JPanel panelTop = new JPanel();
		JLabel labelEscolha = new JLabel("Escolha o tipo de grafo:");
		JButton btnOrientado = new JButton("Grafo Orientado");
		JButton btnNaoOrientado = new JButton("Grafo Não Orientado");
		panelTop.add(labelEscolha);
		panelTop.add(btnOrientado);
		panelTop.add(btnNaoOrientado);
		add(panelTop, BorderLayout.NORTH);

		// Painel central para exibição do grafo
		JTextArea textArea = new JTextArea(20, 50);
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		add(scrollPane, BorderLayout.CENTER);

		// Painel inferior para operações
		JPanel panelBottom = new JPanel();
		JButton btnAddVertice = new JButton("Adicionar Vértice");
		JButton btnAddAresta = new JButton("Adicionar Aresta");
		JButton btnExibirOrdem = new JButton("Exibir Ordem");
		JButton btnExibirGraus = new JButton("Exibir Graus");
		panelBottom.add(btnAddVertice);
		panelBottom.add(btnAddAresta);
		panelBottom.add(btnExibirOrdem);
		panelBottom.add(btnExibirGraus);
		add(panelBottom, BorderLayout.SOUTH);

		// Eventos para escolha do tipo de grafo
		btnOrientado.addActionListener(e -> {
			grafo = new GrafoOrientado();
			textArea.append("Grafo orientado selecionado.\n");
		});

		btnNaoOrientado.addActionListener(e -> {
			grafo = new GrafoNaoOrientado();
			textArea.append("Grafo não orientado selecionado.\n");
		});

		// Eventos de adição de vértices
		btnAddVertice.addActionListener(e -> {
			String nomeVertice = JOptionPane.showInputDialog(this, "Digite o nome do vértice:");
			if (nomeVertice != null && !nomeVertice.trim().isEmpty()) {
				grafo.adicionarVertice(nomeVertice);
				textArea.append("Vértice " + nomeVertice + " adicionado.\n");
			}
		});

		// Eventos de adição de arestas
		btnAddAresta.addActionListener(e -> {
			String origem = JOptionPane.showInputDialog(this, "Digite o vértice de origem:");
			String destino = JOptionPane.showInputDialog(this, "Digite o vértice de destino:");
			if (origem != null && destino != null && !origem.trim().isEmpty() && !destino.trim().isEmpty()) {
				grafo.adicionarAresta(origem, destino);
				textArea.append("Aresta de " + origem + " para " + destino + " adicionada.\n");
			}
		});

		// Eventos de exibição da ordem do grafo
		btnExibirOrdem.addActionListener(e -> {
			if (grafo != null) {
				textArea.append("Ordem do grafo: " + grafo.ordem() + "\n");
			} else {
				textArea.append("Selecione um tipo de grafo primeiro.\n");
			}
		});

		// Eventos de exibição dos graus dos vértices
		btnExibirGraus.addActionListener(e -> {
			if (grafo != null) {
				if (grafo instanceof GrafoOrientado) {
					textArea.append("Graus dos vértices (orientado):\n");
					for (Vertice vertice : grafo.vertices) {
						int grauEntrada = 0;
						int grauSaida = vertice.getArestas().size();

						for (Vertice v : grafo.vertices) {
							for (Aresta aresta : v.getArestas()) {
								if (aresta.getDestino().equals(vertice)) {
									grauEntrada++;
								}
							}
						}

						textArea.append("Vértice " + vertice.getNome() + " - Grau de entrada: " + grauEntrada + ", Grau de saída: " + grauSaida + "\n");
					}
				} else {
					textArea.append("Graus dos vértices (não orientado):\n");
					for (Vertice vertice : grafo.vertices) {
						textArea.append("Vértice " + vertice.getNome() + " - Grau: " + vertice.getGrau() + "\n");
					}
				}
			} else {
				textArea.append("Selecione um tipo de grafo primeiro.\n");
			}
		});
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			MainFrame frame = new MainFrame();
			frame.setVisible(true);
		});
	}
}
