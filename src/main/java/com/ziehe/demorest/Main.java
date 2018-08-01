package com.ziehe.demorest;


import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.search.FullTextQuery;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.jhades.JHades;

import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;

import javax.persistence.*; 

import  org.hibernate.search.jpa.*; 
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.service.ServiceRegistry;
//import org.hibernate.service.ServiceRegistryBuilder;



import org.hibernate.search.jpa.*;
import org.hibernate.search.jpa.impl.FullTextEntityManagerImpl;
import org.hibernate.search.query.dsl.QueryBuilder;

public class Main {

	public static void main(String[] args) {
	}
}
