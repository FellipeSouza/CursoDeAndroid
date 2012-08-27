/*
 * 1) Tabela dinamica
	a) Construa um programa com um campo de texto e um botao. 
	Esse botao deve adicionar o texto inserido em uma tabela 
	(criar uma linha e adicionar o texto nessa linha).
	
	b) Altere o programa para que ele adicione o texto do campo
	em uma nova linha da tabela toda vez que o botao seja clicado.
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

    /* Criando o ArrayList que guardara os textos digitados */
    private static ArrayList<String> textos = new ArrayList<String>();
    
    /* String que passara os dados do campo pro ArrayList */
    String aux;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.primeira_tela);

        /* Referenciando Campo de Texto, Botao e Tabela do XML */
        final EditText campoTexto = (EditText) findViewById(R.id.campoTexto);
        Button botao = (Button) findViewById(R.id.botao);
        final TableLayout tabela = (TableLayout) findViewById(R.id.tabela);
		
        /* Definindo os par�metros da tabela em uma variavel */
	final TableRow.LayoutParams parametroTabela = new TableRow.LayoutParams(LayoutParams.FILL_PARENT, 
				LayoutParams.WRAP_CONTENT);

		/* Definindo as funcoes do clique do botao */
        botao.setOnClickListener(new View.OnClickListener() {
			
		@Override
		public void onClick(View v) {
			/* aux recebe o conteudo do campo de texto */				
			aux = campoTexto.getText().toString();
			
			if (aux != null) {
				/* ArrayList recebe o conteudo do aux */
		        	textos.add(aux);
		        	
		        	/* Deleta o conteudo do campo de texto */
		        	campoTexto.setText("");
		        	
		        	/* Laco de repeticao que vai inserir os dados na tabela */
		        	for (int i = 0; i < textos.size(); i++) {
		        		
		        		/* Criando linha e campo da tabela */
		        		TableRow linha = new TableRow(v.getContext());
		        		TextView itemTabela = new TextView(v.getContext());
		        		
		        		/* Definindo os parametros de layout da linha */
		        		linha.setLayoutParams(parametroTabela);
		        		
		        		/* Inserindo o conte�do do ArrayList no TextView */
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
