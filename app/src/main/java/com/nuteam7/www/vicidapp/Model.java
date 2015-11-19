package com.nuteam7.www.vicidapp;

/**
 * Created by Jesse on 11/19/2015.
 */
public class Model {

    private int _id;
    private String _modelname;
    private String _generation;
    private String _years;
    private String _wikilink;
    private String _brand;
    private String _type;

    public Model(){
    }

    public Model(String modelname){
        this._modelname = modelname;
    }


    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_modelname(String _modelname) {
        this._modelname = _modelname;
    }

    public void set_generation(String _generation) {
        this._generation = _generation;
    }

    public void set_years(String _years) {
        this._years = _years;
    }

    public void set_wikilink(String _wikilink) {
        this._wikilink = _wikilink;
    }

    public void set_brand(String _brand) {
        this._brand = _brand;
    }

    public void set_type(String _type) {
        this._type = _type;
    }


    public int get_id() {
        return _id;
    }

    public String get_modelname() {
        return _modelname;
    }

}
