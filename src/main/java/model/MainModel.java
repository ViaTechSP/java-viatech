package model;

import entidade.EspecificacaoMaquina;

public class MainModel {

    MaquinaModel maquinaModel = new MaquinaModel();
    EspecificacaoMaquinaModel especificacaoMaquinaModel = new EspecificacaoMaquinaModel();

    public Boolean maquinaExists(String dominio){

        return maquinaModel.exibirMaquinaMySql(dominio) != null && maquinaModel.exibirMaquinaSqlServer(dominio) != null;
    }

    public Boolean especificacaoMaquinaExists(Integer fkMaquinaMySql, Integer fkMaquinaSqlServer){
        return especificacaoMaquinaModel.verificarExistenciaMaquinaMySql(fkMaquinaMySql) != null
                && especificacaoMaquinaModel.verificarExistenciaMaquinaSqlServer(fkMaquinaSqlServer) != null;
    }
}
