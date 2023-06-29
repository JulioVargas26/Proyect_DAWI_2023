package dawi.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dawi.project.dao.EntradaDAO;
import dawi.project.dao.ProductoHasEntradaDAO;
import dawi.project.entity.Entradas;
import dawi.project.entity.ProductoHasEntrada;
import dawi.project.entity.ProductoHasEntradaPK;
import jakarta.transaction.Transactional;

@Service
public class EntradaServices {
	@Autowired
	private EntradaDAO repoEntrada;
	
	@Autowired
	private ProductoHasEntradaDAO repoProductoHas;
	
	@Transactional
	public void registrarEntrada(Entradas bean) {
		try {
			repoEntrada.save(bean);
			
			for(ProductoHasEntrada phe:bean.getListaProductoHasEntrada()) {
				ProductoHasEntradaPK pk = new ProductoHasEntradaPK();
				pk.setIdEntradas(bean.getCodigo());
				pk.setIdProducto(phe.getProducto().getIdproducto());
				
				phe.setPk(pk);
				
				repoProductoHas.save(phe);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public List<Entradas> listarEntradas() {
		// TODO Auto-generated method stub
		return repoEntrada.findAll();
	}

	public List<Entradas> listarPorProveedor(int cod) {
		// TODO Auto-generated method stub
		return repoEntrada.listaPorEntrada(cod);
	}
}
