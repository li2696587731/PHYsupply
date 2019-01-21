package com.supply.springboot.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "symbol")
@Data
public class Symbol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "s_id")
    private int sid;
    @Column(name = "e_id")
    private String eid;
    @Column(name = "sname")
    private String sname;
    private String market;
    private String type;

    public Symbol() {
    }

    public Symbol(String e_id, String sname, String market, String type) {
        this.eid = e_id;
        this.sname = sname;
        this.market = market;
        this.type = type;
    }
}
