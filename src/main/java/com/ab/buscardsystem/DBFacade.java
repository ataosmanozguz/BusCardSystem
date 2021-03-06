package com.ab.buscardsystem;

public class DBFacade {

    private TableMapper tableMapper = new TableMapper();
    private IDataBase iDataBase;
    private BusConsole busConsole;
    private CenterConsole centerConsole;

    public Object get(int id, Class<?> parameterClass){
        iDataBase = tableMapper.getMapper(parameterClass);
        return iDataBase.getItem(id);
    }

    public void delete(int id, Class<?> parameterClass){
        iDataBase = tableMapper.getMapper(parameterClass);
        iDataBase.deleteItem(id);
    }

    public void update(ParentObject object){
        IDataBase DBMapper = tableMapper.getMapper(object.getClass());
        DBMapper.updateItem(object);
    }

    public void put(ParentObject object){
        IDataBase DBMapper = tableMapper.getMapper(object.getClass());
        DBMapper.putItem(object);
    }

    public void setTableMapper(TableMapper tableMapper) {
        this.tableMapper = tableMapper;
    }
    public void setiDataBase(IDataBase iDataBase) {
        this.iDataBase = iDataBase;
    }
    public TableMapper getTableMapper() {
        return tableMapper;
    }
    public IDataBase getiDataBase() {
        return iDataBase;
    }
    public BusConsole getBusConsole() {
        return busConsole;
    }
    public void setBusConsole(BusConsole busConsole) {
        this.busConsole = busConsole;
    }
    public CenterConsole getCenterConsole() {
        return centerConsole;
    }
    public void setCenterConsole(CenterConsole centerConsole) {
        this.centerConsole = centerConsole;
    }

}
