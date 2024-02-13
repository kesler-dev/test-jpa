@GenericGenerator(name = "nsi-sequence-generator",
        strategy = "sequence",
        parameters = {
                @Parameter(name = "optimizer", value = "pooled"),
                // при использовании и также при изменении increment_size необходимо обновить INCREMENT BY у SEQUENCE
                // см. db/changelog/1.0/update_seq.xml
                @Parameter(name = "increment_size",  value = "50"),
                @Parameter(name = "prefer_sequence_per_entity", value = "true"),
                @Parameter(name = "sequence_per_entity_suffix", value = "_id_seq"),
        })
package com.example.testjpa.domain;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
