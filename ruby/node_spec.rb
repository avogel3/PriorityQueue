require_relative 'node'

RSpec.describe Node do
    it { should respond_to(:name) }
    it { should respond_to(:priority) } 

    it "inits a node that is 'empty'" do
      node = Node.new
      expect(node.name).to eq "__empty__"
      expect(node.priority).to eq -1
    end

    it "inits a node with name and priority" do
       node = Node.new("Walter", 21)
       expect(node.name).to eq "Walter"
       expect(node.priority).to eq 21
    end
end
