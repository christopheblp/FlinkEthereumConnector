import com.bigeek.flink.batch.connectors.ethereum.EthereumInputSource;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.DataSource;
import org.web3j.contracts.token.ERC20Interface;
import org.web3j.protocol.core.methods.response.EthBlock;
import org.web3j.protocol.core.methods.response.Transaction;

import java.util.List;


/**
 * Launch this command before :
 * geth  --rpc --rpcaddr 127.0.0.1 --rpcport 8545 --rpcapi="db,eth,net,web3,personal,debug" --rpccorsdomain "*"
 */

public class EthereumJob {


    public static void main(String[] args) throws Exception {
        final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        DataSource<EthBlock> list = env.createInput(new EthereumInputSource("http://localhost:8545", 4000000, 4000001));

        System.out.println(list.collect().get(0).getBlock());
        //Transaction t= new Transaction();
        //System.out.println("counter: "+ list.count());
        //env.execute("Job");


    }
}