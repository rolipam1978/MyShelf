
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author RAMIRO
 */
public class ShelfControl {
    
    PreparedStatement pstm;
    ResultSet rs;
    
    // Incluir TIPO
    public void incluirTipo(ShelfBean sb){
        ConexaoBD con = new ConexaoBD();
        try{
            String sql = "insert into tipos (tipo) values (?)";
            pstm = con.conecta().prepareStatement(sql);
            pstm.setString(1, sb.getTipo());
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro Gravado com Sucesso!");
            
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não Foi Possível Gravar o Registro!");
        }finally{
            con.desconecta();
        }
    }
    
    // Incluir GENERO
    public void incluirGenero(ShelfBean sb){
        ConexaoBD con = new ConexaoBD();
        try{
            String sql = "insert into generos (genero) values (?)";
            pstm = con.conecta().prepareStatement(sql);
            pstm.setString(1, sb.getGenero());
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro Gravado com Sucesso!");
            
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não Foi Possível Gravar o Registro!");
        }finally{
            con.desconecta();
        }
    }
    
    // SALVAR
    public void salvar(ShelfBean sb){
        ConexaoBD con = new ConexaoBD();
        try{
            String sql = "insert into titulos (tipo, titulo, genero, ano, artista, diretor, elenco, autor, sinopse) "
                    + "values (?,?,?,?,?,?,?,?,?)";
            pstm = con.conecta().prepareStatement(sql);
            pstm.setString(1, sb.getTipo());
            pstm.setString(2, sb.getTitulo());
            pstm.setString(3, sb.getGenero());
            pstm.setString(4, sb.getAno());
            pstm.setString(5, sb.getArtista());
            pstm.setString(6, sb.getDiretor());
            pstm.setString(7, sb.getElenco());
            pstm.setString(8, sb.getAutor());
            pstm.setString(9, sb.getSinopse());
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro Gravado com Sucesso!");
            
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não Foi Possível Gravar o Registro!");
        }finally{
            con.desconecta();
        }
    }
    
    // ALTERAR
    public void alterar(ShelfBean sb){
        ConexaoBD con = new ConexaoBD();
        try{
            String sql = "update titulos set tipo=?, genero=?, ano=?, artista=?, diretor=?, elenco=?, autor=?, "
                    + "sinopse=? where titulo=?";
            pstm = con.conecta().prepareStatement(sql);
            pstm.setString(1, sb.getTipo());
            pstm.setString(2, sb.getGenero());
            pstm.setString(3, sb.getAno());
            pstm.setString(4, sb.getArtista());
            pstm.setString(5, sb.getDiretor());
            pstm.setString(6, sb.getElenco());
            pstm.setString(7, sb.getAutor());
            pstm.setString(8, sb.getSinopse());
            pstm.setString(9, sb.getTitulo());
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro Alterado com Sucesso!");
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não Foi Possível Alterar o Registro!");
        }finally{
            con.desconecta();
        }
    }
    
    // EXCLUIR
    public void excluir(ShelfBean sb){
        ConexaoBD con = new ConexaoBD();
        String sql = "delete from titulos where titulo = ?";
        String nome = "Deseja deletar o título " + sb.getTitulo()+ "?";
        int opcao = JOptionPane.showConfirmDialog(null, nome, "Deletar Título", JOptionPane.YES_NO_OPTION);
        try{
            pstm = con.conecta().prepareStatement(sql);
            pstm.setString(1, sb.getTitulo());
            if (opcao == JOptionPane.YES_OPTION) {
                //pstm.executeUpdate();
                int excluiu = pstm.executeUpdate();
                if (excluiu == 1) {
                    JOptionPane.showMessageDialog(null, "Registro Excluído com Sucesso!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Registro Não Foi Excluído!");
            }
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não Foi Possível Excluir o Registro!");
        }finally{
            con.desconecta();
        }
    }
    
    // LISTAR
    public List<ShelfBean> listarTitulos(String nome){
        List<ShelfBean> titulos = new ArrayList();
        ConexaoBD con = new ConexaoBD();
        String sql = "select * from titulos where tipo like ? order by titulo";
        try{
            pstm = con.conecta().prepareStatement(sql);
            pstm.setString(1, nome);
            rs = pstm.executeQuery();
            ShelfBean sb;
            while(rs.next()){
                sb = new ShelfBean();
                sb.setTipo(rs.getString("tipo"));
                sb.setTitulo(rs.getString("titulo"));
                sb.setGenero(rs.getString("genero"));
                sb.setAno(rs.getString("ano"));
                sb.setArtista(rs.getString("artista"));
                sb.setDiretor(rs.getString("diretor"));
                sb.setElenco(rs.getString("elenco"));
                sb.setAutor(rs.getString("autor"));
                sb.setSinopse(rs.getString("sinopse"));
                titulos.add(sb);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            con.desconecta();
        }
        return titulos;
    }
}
