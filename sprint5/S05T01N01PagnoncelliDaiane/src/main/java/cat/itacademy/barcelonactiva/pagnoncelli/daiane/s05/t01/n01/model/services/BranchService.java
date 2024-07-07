package cat.itacademy.barcelonactiva.pagnoncelli.daiane.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.pagnoncelli.daiane.s05.t01.n01.model.dto.BranchDTO;

import java.util.List;

public interface BranchService {
    void saveBranch(BranchDTO branchDto);
    BranchDTO updateBranch(int id, BranchDTO branchDto);
    void deleteBranch(int id);
    BranchDTO getOneBranch(int id);
    List<BranchDTO> getAllBranches();
}


