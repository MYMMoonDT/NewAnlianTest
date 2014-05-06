package edu.tongji.anliantest.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.tongji.anliantest.model.ContractReviewRecordItem;
import edu.tongji.anliantest.model.ContractReviewRecordTable;
import edu.tongji.anliantest.utils.ContractReviewForm;

@Repository
public class ContractReviewTableDao extends BaseDao<ContractReviewRecordTable>{
	private final String GET_CONTRACT_REVIEW_TABLE_BY_PROJECT_ID = "from ContractReviewRecordTable c where c.projectInfo.projectId = ?";
	
	@Autowired
	private ContractReviewItemDao contractReviewItemDao;
	
	public ContractReviewRecordTable getContractReviewTableByProjectId(int projectId){
		List<ContractReviewRecordTable> list = (List<ContractReviewRecordTable>)find(GET_CONTRACT_REVIEW_TABLE_BY_PROJECT_ID, projectId);
		if(list.size() > 0){
			return list.get(0);
		}else{
			return null;
		}
	}
	
	public void signContractReviewTable(int tableId){
		ContractReviewRecordTable table = load(tableId);
		table.setTableStatus(ContractReviewForm.Status.signed.toString());
		update(table);
	}
	
	public boolean checkContractReviewTable(int tableId){
		boolean result = true;
		ContractReviewRecordTable table = load(tableId);
		List<ContractReviewRecordItem> list = contractReviewItemDao.getContractReviewItemByTableId(tableId);
		for(int i = 0; i < list.size(); i++){
			if(list.get(i).getItemStatus().equals(ContractReviewForm.ItemStatus.unsigned.toString())){
				result = false;
				break;
			}
		}
		if(table.getTableStatus().equals(ContractReviewForm.Status.unsigned.toString())){
			result = false;
		}
		return result;
	}
}
