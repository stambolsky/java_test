package ru.stqa.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.Set;

public class Contacts extends ForwardingSet<ContactData> {
    @Override
    protected Set<ContactData> delegate() {
        return null;
    }
}
