package edu.tongji.anliantest.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.tongji.anliantest.model.ContractReviewRecordItem;
import edu.tongji.anliantest.model.ContractReviewRecordTable;
import edu.tongji.anliantest.model.DepartmentInfo;
import edu.tongji.anliantest.utils.ContractReviewForm;

@Repository
public class ContractReviewItemDao extends BaseDao<ContractReviewRecordItem>{		
	private final String GET_CONTRACT_REVIEW_ITEM_BY_TABLE_ID = "from ContractReviewRecordItem c where c.contractReviewRecordTable.tableId = ?";
	private final String SIGN_CONTRACT_REVIEW_ITEM = "update ContractReviewRecordItem c set c.itemStatus = 'signed' where c.contractReviewRecordTable.tableId = ? and c.departmentInfo.departmentId = ?";
	
	/*public void signContractReviewItem(ContractReviewRecordTable table, DepartmentInfo department){
		ContractReviewRecordItem item = new ContractReviewRecordItem();
		item.setContractReviewRecordTable(table);
		item.setDepartmentInfo(department);
		List<ContractReviewRecordItem> list = getHibernateTemplate().findByExample(item);
		if(list.size() == 1){
			item = list.get(0);
			item.setItemStatus(ContractReviewForm.ItemStatus.signed.toString());
			getHibernateTemplate().update(item);
		}
	}*/
	public void signContractReviewItem(ContractReviewRecordTable table, DepartmentInfo department){
		getHibernateTemplate().bulkUpdate(SIGN_CONTRACT_REVIEW_ITEM, table.getTableId(), department.getDepartmentId());
	}
	
	public List<ContractReviewRecordItem> getContractReviewItemByTableId(int tableId){
		return (List<ContractReviewRecordItem>)find(GET_CONTRACT_REVIEW_ITEM_BY_TABLE_ID, tableId);
	}
}
