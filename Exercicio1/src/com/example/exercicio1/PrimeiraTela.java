/*
 * 1) Tabela dinâmica
	a) Construa um programa com um campo de texto e um botão. Esse botão deve adicionar o texto inserido em uma tabela (criar uma linha e adicionar o texto nessa linha).
	b) Altere o programa para que ele adicione o texto do campo em uma nova linha da tabela toda vez que o botão seja clicado.
 */

package com.example.exercicio1;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.TableRow.LayoutParams;

public class PrimeiraTela extends Activity {

	/* Criando o ArrayList que guardará os textos digitados */
    private static ArrayList<String> textos = new ArrayList<String>();
    
    /* String que passará os dados do campo pro ArrayList */
    String aux;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.primeira_tela);

        /* Referenciando Campo de Texto, Botão e Tabela do XML */
        final EditText campoTexto = (EditText) findViewById(R.id.campoTexto);
        Button botao = (Button) findViewById(R.id.botao);
        final TableLayout tabela = (TableLayout) findViewById(R.id.tabela);
		
        /* Definindo os parâmetros da tabela em uma variável */
		final TableRow.LayoutParams parametroTabela = new TableRow.LayoutParams(LayoutParams.FILL_PARENT, 
				LayoutParams.WRAP_CONTENT);

		/* Definindo as funções do clique do botão */
        botao.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				/* aux recebe o conteúdo do campo de texto */				
				aux = campoTexto.getText().toString();
				
				if (aux != null) {
					/* ArrayList recebe o conteúdo do aux */
		        	textos.add(aux);
		        	
		        	/* Deleta o conteúdo do campo de texto */
		        	campoTexto.setText("");
		        	
		        	/* Laço de repetição que vai inserir os dados na tabela */
		        	for (int i = 0; i < textos.size(); i++) {
		        		
		        		/* Criando linha e campo da tabela */
		        		TableRow linha = new TableRow(v.getContext());
		        		TextView itemTabela = new TextView(v.getContext());
		        		
		        		/* Definindo os parametros de layout da linha */
		        		linha.setLayoutParams(parametroTabela);
		        		
		        		/* Inserindo o conteúdo do ArrayList no TextView */
		        		itemTabela.setText(textos.get(i));
		        		
		        		/* Limpando o ArrayList */
		        		textos.clear();
		        		
		        		/* Inserindo o TextView na linha */
		        		linha.addView(itemTabela);
		        		
		        		/* Inserindo a linha na tabela */
		        		tabela.addView(linha, parametroTabela);
		        	}
		        }
			}
		});
    }
}
