package com.slt.designpatterns.visitor;

interface Visitor {
    void visitCpu(CPU cpu);
    void visitMemory(Memory memory);
    void visitBoard(Board board);
}
